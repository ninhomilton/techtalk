package com.epam.techtalk.taskmanager.lifecycle;

import com.epam.techtalk.taskmanager.TechtalkApplication;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {

    private static final Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);

    @PostConstruct
    public void init() {
        logger.info("Task Manager LifecycleBean initialized!");
    }

    @PreDestroy
    public void cleanup() {
        logger.info("Task Manager LifecycleBean cleaned up!");
    }
}
