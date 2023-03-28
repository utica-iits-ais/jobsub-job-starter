package edu.utica.spring.boot.starter.jobsub.job;

import edu.utica.spring.boot.starter.jobsub.job.user.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.jdbc.core.JdbcTemplate;

public class BannerJob {

    private final ApplicationArguments applicationArguments;
//    private final JdbcTemplate jdbcTemplate;
    private final String name;
    private final String number;
    private final User user;

    public BannerJob(ApplicationArguments applicationArguments) {
        System.out.println("Did this autoconfiguration for BannerJob run before the bean object was requested");
        this.applicationArguments = applicationArguments;
//        this.jdbcTemplate = jdbcTemplate;

        if (applicationArguments.getSourceArgs().length == 2) {
            this.name = applicationArguments.getSourceArgs()[0];
            this.number = applicationArguments.getSourceArgs()[1];
            this.user = null;
        } else {
            this.name = null;
            this.number = null;
            this.user = null;
            throw new RuntimeException("Spring Application Run must have only two args getJobName() and getJobNumber() passed down from the BannerBatchProcessor processJob method.");
        }

    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }
}
