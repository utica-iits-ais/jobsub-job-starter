package edu.utica.spring.boot.starter.jobsub.job;

import org.springframework.boot.ApplicationArguments;

public class Job {

    private final ApplicationArguments applicationArguments;
    private String name;
    private String number;

    public Job(ApplicationArguments applicationArguments) {
        this.applicationArguments = applicationArguments;

        if (applicationArguments.getSourceArgs().length == 2) {
            name = applicationArguments.getSourceArgs()[0];
            number = applicationArguments.getSourceArgs()[1];
        } else {
            throw new RuntimeException("Spring Application Run must have only two args getJobName() and getJobNumber() passed down from the BannerBatchProcessor processJob method.");
        }
    }

    public String getJobName() {
        return name;
    }

    public String getJobNumber() {
        return number;
    }


}
