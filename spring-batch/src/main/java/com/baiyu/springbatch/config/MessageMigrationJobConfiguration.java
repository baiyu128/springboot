package com.baiyu.springbatch.config;

import com.baiyu.springbatch.entity.Person;
import com.baiyu.springbatch.listener.JobCompletionNotificationListener;
import com.baiyu.springbatch.processor.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
/**
 *
 * @author yx
 */
@Configuration
@EnableAutoConfiguration
public class MessageMigrationJobConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * @desc: 从文件中读取源数据
     * @param: []
     * @return: org.springframework.batch.item.file.FlatFileItemReader<com.springboot.springbatch.entity.Person>
     **/
    @Bean
    public FlatFileItemReader<Person> reader() {
        // 读取文件
        FlatFileItemReader<Person> itemReader = new FlatFileItemReader<>();
        // 设置文件路径
        itemReader.setResource(new ClassPathResource("file/person-data.csv"));

        // 数据和领域模型类做对应映射
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();

        fieldSetMapper.setTargetType(Person.class);
        lineTokenizer.setNames("firstName", "lastName");
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        itemReader.setLineMapper(lineMapper);

        return itemReader;
    }

    /**
     * @desc: 注入数据处理器
     * @author: gxing
     * @date: 2018/9/17 10:57
     * @param: []
     * @return: com.springboot.springbatch.job.PersonItemProcessor
     **/
    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    /**
     * @desc: 输出数据,自动配置了DataSource,以参数方式注入
     * @param: [dataSource]
     * @return: org.springframework.batch.item.database.JdbcBatchItemWriter<com.springboot.springbatch.entity.Person>
     **/
    @Bean
    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
        // 写入到数据库
        JdbcBatchItemWriter<Person> itemWriter = new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>())
                .sql("INSERT INTO person (first_name, last_name) VALUES (:firstName, :lastName)")
                .dataSource(dataSource)
                .build();
        return itemWriter;
    }

    /**
     * @desc: 定义作业。作业是根据步骤构建的。
     * @param: [listener, step1]
     * @return: org.springframework.batch.core.Job
     **/
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    /**
     * @desc: 定义单个Step步骤, 每个步骤涉及读者，处理器和编写者
     * @param: [itemWriter]
     * @return: org.springframework.batch.core.Step
     **/
    @Bean
    public Step step1(JdbcBatchItemWriter<Person> itemWriter) {

        //定义一次写入数据量,此处是10条
        //chunk()前辍<Person, Person>表示输入和输出类型,并与ItemReader <Person>和ItemWriter <Person>对齐
        //在使用之前注入 ItemReader、ItemProcessor 和 ItemWriter
        return stepBuilderFactory.get("step1").<Person, Person>chunk(10000)
                .reader(reader())
                .processor(processor())
                .writer(itemWriter)
                .build();
    }
}