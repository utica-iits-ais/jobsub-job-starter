package edu.utica.spring.boot.starter.jobsub.job.parameters;

import edu.utica.spring.boot.starter.jobsub.job.user.BannerJobUserRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BannerParameterRepository {

    private final JdbcTemplate jdbcTemplate;

    public BannerParameterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BannerParameter> queryBannerParameters(String jobName, String jobNumber) {
        List<BannerParameter> list =
                jdbcTemplate.query("""
                        select gjbprun_job job,
                               gjbprun_one_up_no one_up,
                               gjbprun_number "number",
                               gjbprun_activity_date activity,
                               gjbprun_value value,
                               gjbprun_label label,
                               gjbprun_user_id user_id,
                               gjbpdef_desc description,
                               gjbpdef_length length,
                               gjbpdef_type_ind type,
                               gjbpdef_optional_ind optional_ind,
                               gjbpdef_single_ind single_ind,
                               gjbpdef_low_range low_range,
                               gjbpdef_high_range high_range,
                               gjbpdef_help_text help_text,
                               gjbpdef_validation validation,
                               gjbpdef_list_values list_values
                          from gjbprun, gjbpdef
                         where gjbprun_job = ?
                           and gjbprun_one_up_no = ?
                           and gjbprun_job = gjbpdef_job
                           and gjbprun_number = gjbpdef_number
                        order by gjbprun_number
                        """,
                        new BeanPropertyRowMapper<>(BannerParameter.class),
                        new Object[]{jobName,jobNumber});
        return list;
    }
    public List<BannerParameterDefinition> queryBannerParameterDefinitions(String jobName) {
        List<BannerParameterDefinition> list =
                jdbcTemplate.query("""
                        select gjbpdef_job job,
                               gjbpdef_number "number",
                               gjbpdef_desc description,
                               gjbpdef_length length,
                               gjbpdef_type_ind type,
                               gjbpdef_optional_ind optional_ind,
                               gjbpdef_single_ind single_ind,
                               gjbpdef_low_range low_range,
                               gjbpdef_high_range high_range,
                               gjbpdef_help_text help_text,
                               gjbpdef_validation validation,
                               gjbpdef_list_values list_values,
                               (select decode(count(*),0,'N','Y') from gjbpval
                                 where gjbpval_job = gjbpdef_job
                                   and gjbpval_number = gjbpdef_number) has_pval,
                               CURSOR(select gjbpval_value from gjbpval
                                       where gjbpval_job = gjbpdef_job
                                         and gjbpval_number = gjbpdef_number
                                      order by gjbpval_value asc) pval_list
                          from gjbpdef
                         where gjbpdef_job = ?
                        order by gjbpdef_number
                        """,
                        (rs, rowNum) -> {
                            BannerParameterDefinition def = new BannerParameterDefinition();
                            def.setJob(rs.getString("job"));
                            def.setNumber(rs.getString("number"));
                            def.setDescription(rs.getString("description"));
                            def.setLength(rs.getInt("length"));
                            def.setType(rs.getString("type"));
                            def.setOptionalInd(rs.getString("optional_ind"));
                            def.setSingleInd(rs.getString("single_ind"));
                            def.setLowRange(rs.getString("low_range"));
                            def.setHighRange(rs.getString("high_range"));
                            def.setHelpText(rs.getString("help_text"));
                            def.setValidation(rs.getString("validation"));
                            def.setListValues(rs.getString("list_values"));
                            def.setHasPval(rs.getString("has_pval"));
                            if ("Y".equals(def.getHasPval())) {
                                try (ResultSet rsPval = (ResultSet) rs.getObject("pval_list")) {
                                    while (rsPval.next()) {
                                        def.getPvalList().add(rsPval.getString("pval"));
                                    }
                                }
                            }
                            return def;
                        },
                        new Object[]{jobName});
        return list;
    }

}
