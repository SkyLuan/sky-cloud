package com.sky.cloud.flowable;

import org.flowable.engine.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoFlowableApplicationTests {


    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;//
    @Autowired
    private HistoryService historyService;//历史数据
    @Autowired
    private ProcessEngine processEngine;


    @Test
    void contextLoads() {
        //创建一个审批流
//        runtimeService.startProcessInstanceByKey("",map).getId();






    }

}
