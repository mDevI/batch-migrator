package com.mdevi.batchmigrator.batch.config;

import com.mdevi.batchmigrator.domain.Employee;
import com.mdevi.batchmigrator.domain.Person;
import com.mdevi.batchmigrator.repository.PersonRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Collections;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public MongoTemplate mongoTemplate;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public PersonRepository repository;

    // tag::readerwriterprocessor[]

    @Bean
    public RepositoryItemReader<Person> personReader() {
        Map<String, Sort.Direction> sorts = Collections.singletonMap("id", Sort.Direction.ASC);
        return new RepositoryItemReaderBuilder<Person>()
                .name("databaseReader")
                .repository(repository)
                .sorts(sorts)
                .methodName("findAll")
                .pageSize(10)
                .build();
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public MongoItemWriter<Employee> mongoWriter() {
        return new MongoItemWriterBuilder<Employee>()
                .template(mongoTemplate)
                .collection("employees")
                .build();
    }

    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importNewEmployeeJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(MongoItemWriter<Employee> mongoWriter) {
        return stepBuilderFactory.get("step1")
                .<Person, Employee>chunk(5)
                .reader(personReader())
                //.reader(reader())
                .processor(processor())
                //.writer(writer)
                .writer(mongoWriter())
                .build();
    }
    // end::jobstep[]
}
