package edu.utica.spring.boot.starter.jobsub.job;

import com.sct.messaging.bif.BatchResourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;


@AutoConfiguration
@ConditionalOnClass({BannerJob.class})
@ConditionalOnBean({ApplicationArguments.class, DataSource.class})
public class BannerJobAutoConfiguration {

    private final ApplicationArguments applicationArguments;
    private final DataSource dataSource;

    @Autowired
    public BannerJobAutoConfiguration(ApplicationArguments applicationArguments, DataSource dataSource) {
        System.out.println("BannerJobAutoConfiguration");
        this.applicationArguments = applicationArguments;
        this.dataSource = dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    BannerJob getBannerJob() {
        return new BannerJob(applicationArguments,dataSource);
    }


}
