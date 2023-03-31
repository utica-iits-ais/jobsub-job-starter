package edu.utica.spring.boot.starter.jobsub.job;

import edu.utica.spring.boot.starter.jobsub.job.parameters.Parameters;
import edu.utica.spring.boot.starter.jobsub.job.user.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class BannerJob {

    private final ApplicationArguments applicationArguments;
    private final JdbcTemplate jdbcTemplate;
    private String name = null;
    private String number = null;
    private User user = null;
    private Parameters parameters = null;

    public BannerJob() {
        this.applicationArguments = null;
        this.jdbcTemplate = null;
    }
    public BannerJob(ApplicationArguments applicationArguments, DataSource dataSource) {
        this.applicationArguments = applicationArguments;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        if (applicationArguments.getSourceArgs().length != 2) {
            throw new RuntimeException("Spring Application Run must have only two args getJobName() and getJobNumber() passed down from the BannerBatchProcessor processJob method.");
        }

        this.name = applicationArguments.getSourceArgs()[0];
        this.number = applicationArguments.getSourceArgs()[1];
        this.user = new User(jdbcTemplate);
        this.parameters = new Parameters(jdbcTemplate,this.name,this.number);

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Parameters getParameters() {
        return parameters;
    }
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
