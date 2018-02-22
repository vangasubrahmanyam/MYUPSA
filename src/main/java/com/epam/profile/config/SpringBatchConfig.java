package com.epam.profile.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.epam.profile.model.Employee;

@Configuration
@EnableBatchProcessing
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.epam.profile")
public class SpringBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilders;
	@Autowired
	private StepBuilderFactory stepBuilders;
	
	
	@Bean
	public Job flatfileToDbJob() throws Exception{
		return jobBuilders.get("exportUsersJob")
				.start(step())
				.build();
	}
	@Bean
	public Step step() throws Exception{
		return stepBuilders.get("step")
				.<Employee,Employee>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public ItemReader<Employee> reader() throws Exception {
		String jpqlQuery = "select u from Employee u";
		JpaPagingItemReader<Employee> reader = new JpaPagingItemReader<Employee>();
		reader.setQueryString(jpqlQuery);
		reader.setEntityManagerFactory(this.entityManagerFactory().getObject());
		
		reader.afterPropertiesSet();
		reader.setSaveState(true);
		return reader;
	}
	@Bean
	public ItemWriter<Employee> writer() throws Exception {
		return  new UserExportExcelWriter();
	}
	
	  @Bean
	    public ItemProcessor<Employee,Employee> processor() {
	        return new UserItemProcessor();
	    }

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.epam.profile.model");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		entityManagerFactoryBean.setJpaProperties(additionalProperties());
		return entityManagerFactoryBean;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/epam");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		// properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
