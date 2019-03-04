package com.exemplo.sislog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SislogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SislogApplication.class, args);
	}
	
	
	
	/*
	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
	return new SpringProcessEngineConfiguration();
	}

	@Bean
	public ProcessEngineFactoryBean processEngine() {
	ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
	factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
	return factoryBean;
	}
	@Bean
	public RepositoryService repositoryService() {
	return processEngine().getProcessEngineConfiguration().getRepositoryService();
	}

	@Bean RuntimeService runtimeService(){
	return processEngine().getProcessEngineConfiguration().getRuntimeService();
	}

	@Bean TaskService taskService(){
	return processEngine().getProcessEngineConfiguration().getTaskService();
	}
	@Bean
	public CommandLineRunner init(final RepositoryService repositoryService, final RuntimeService runtimeService,
			final TaskService taskService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				System.out.println(
						"Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
				System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
				runtimeService.startProcessInstanceByKey("oneTaskProcess");
				System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
			}
		};
	}*/
}
