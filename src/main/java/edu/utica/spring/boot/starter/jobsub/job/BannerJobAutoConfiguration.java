package edu.utica.spring.boot.starter.jobsub.job;

import com.sct.messaging.bif.BatchResourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;


@AutoConfiguration
@ConditionalOnClass({BannerJob.class,BatchResourceHolder.class})
@ConditionalOnBean({ApplicationArguments.class})
//@ConditionalOnBean({JdbcTemplate.class})
public class BannerJobAutoConfiguration {

    private final ApplicationArguments applicationArguments;

    @Autowired
    public BannerJobAutoConfiguration(ApplicationArguments applicationArguments) {
        System.out.println("BannerJobAutoConfiguration");
        this.applicationArguments = applicationArguments;
    }

    @Bean
    @ConditionalOnMissingBean
    BannerJob getJob() {
        return new BannerJob(applicationArguments);
    }


}
