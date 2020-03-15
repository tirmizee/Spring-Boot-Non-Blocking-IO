package com.tirmizee.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

	public static final String TASK_EXECUTOR_DEFAULT = "taskExecutorDefault";
	public static final String TASK_EXECUTOR_SERVICE = "taskExecutorService";
	public static final String TASK_EXECUTOR_REPOSITORY = "taskExecutorRepository";
	public static final String TASK_EXECUTOR_CONTROLLER = "taskExecutorController";
	
	@Bean(name = TASK_EXECUTOR_SERVICE)
    public Executor serviceAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }
	
	@Bean(name = TASK_EXECUTOR_CONTROLLER)
    public Executor controllerAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }
	
	@Bean(name = TASK_EXECUTOR_REPOSITORY)
    public Executor repositoryAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }
	
	@Bean(name = TASK_EXECUTOR_DEFAULT)
	@Override
	public Executor getAsyncExecutor() {
		return AsyncConfigurer.super.getAsyncExecutor();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}

}
