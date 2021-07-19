package com.baiyu.springbatch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/7/7
 */
@Configuration
public class SpringBatchConfiguration {
    /*@Bean
    public ApplicationContextFactory firstJobContext() {
        return new GenericApplicationContextFactory(FirstJobConfiguration.class);
    }

    @Bean
    public ApplicationContextFactory secondJobContext() {
        return new GenericApplicationContextFactory(SecondJobConfiguration.class);
    }

    @Bean
    public ApplicationContextFactory messageMigrationJobContext() {
        return new GenericApplicationContextFactory(MessageMigrationJobConfiguration.class);
    }*/
}
