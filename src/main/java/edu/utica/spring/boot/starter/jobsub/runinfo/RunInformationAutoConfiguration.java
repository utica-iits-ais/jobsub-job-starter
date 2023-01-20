package edu.utica.spring.boot.starter.jobsub.runinfo;

import com.sct.messaging.bif.BatchResourceHolder;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;


@AutoConfiguration
@ConditionalOnClass({BatchResourceHolder.class})
@ConditionalOnBean({JdbcTemplate.class})
public class RunInformationAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    SingleConnectionDataSource getDataSource() {
        return new SingleConnectionDataSource(BatchResourceHolder.getConnection(),true);
    }


}
