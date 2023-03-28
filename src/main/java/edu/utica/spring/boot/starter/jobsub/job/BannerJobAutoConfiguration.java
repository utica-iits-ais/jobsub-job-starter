package edu.utica.spring.boot.starter.jobsub.job;

import com.sct.messaging.bif.BatchResourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@AutoConfiguration
@ConditionalOnClass({BannerJob.class})
@ConditionalOnBean({ApplicationArguments.class})
public class BannerJobAutoConfiguration {

    private final ApplicationArguments applicationArguments;
//    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BannerJobAutoConfiguration(ApplicationArguments applicationArguments) {
        System.out.println("BannerJobAutoConfiguration Constructor");
        this.applicationArguments = applicationArguments;
//        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    @ConditionalOnMissingBean
    BannerJob getBannerJob() {
        return new BannerJob(applicationArguments);
    }


}
