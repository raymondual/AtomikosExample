package com.mysoft.atomikos;

import com.mysoft.atomikos.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan("com.mysoft.atomikos")
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@Import({DataSourceConfig.class})
public class AtomikosApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AtomikosApplication.class, args);
    }
}
