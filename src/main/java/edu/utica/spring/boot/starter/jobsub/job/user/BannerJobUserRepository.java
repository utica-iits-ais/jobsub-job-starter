package edu.utica.spring.boot.starter.jobsub.job.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class BannerJobUserRepository {

    public static User getUserFromConnection(JdbcTemplate jdbcTemplate) {
        String username = null;
        try {
            username = jdbcTemplate.getDataSource().getConnection().getMetaData().getUserName();
        } catch (SQLException sqlException) {
            return null;
        }
        try {
            User user = jdbcTemplate.queryForObject("""
                    select a.gobeacc_username user_name,
                           e.goremal_email_address email,
                           a.gobeacc_pidm pidm,
                           i.spriden_id banner_id,
                           coalesce(p.spbpers_pref_first_name,spriden_first_name) first_name,
                           i.spriden_last_name last_name
                      from gobeacc a, spriden i, spbpers p, goremal e
                     where a.gobeacc_username = ?
                       and i.spriden_change_ind is null
                       and i.spriden_pidm = a.gobeacc_pidm
                       and i.spriden_pidm = p.spbpers_pidm(+)
                       and e.goremal_pidm = i.spriden_pidm
                       and e.goremal_emal_code = 'UC'
                       and e.goremal_status_ind = 'A'
                    """,
                    new BeanPropertyRowMapper<>(User.class),
                    new Object[]{username});
            return user;
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return null;
        }
    }

}
