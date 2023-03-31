package edu.utica.spring.boot.starter.jobsub.job.parameters;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parameters {

    private List<BannerParameter> list = null;
    private List<BannerParameterDefinition> definitions = null;
    private Map<String,Object> map = null;

    public Parameters(JdbcTemplate jdbcTemplate, String jobName, String jobNumber) {
        if (jobName == null) {
            throw new RuntimeException("The Banner Job Name cannot be null.");
        }

        BannerParameterRepository bannerParameterRepository =
                new BannerParameterRepository(jdbcTemplate);

        this.definitions = bannerParameterRepository.queryBannerParameterDefinitions(jobName);

        if (jobNumber != null) {
            this.list = bannerParameterRepository.queryBannerParameters(jobName,jobNumber);
        } else {

        }

    }

    public static Map<String,Object> parameterRecordsToMap(List<BannerParameter> list, boolean keyDescription) {
        Map<String,Object> map = new LinkedHashMap<>();
        return map;
    }

    public List<BannerParameter> getList() {
        return list;
    }

    public void setList(List<BannerParameter> list) {
        this.list = list;
    }

    public List<BannerParameterDefinition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<BannerParameterDefinition> definitions) {
        this.definitions = definitions;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
