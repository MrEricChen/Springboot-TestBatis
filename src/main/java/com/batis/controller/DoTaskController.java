package com.batis.controller;

import com.batis.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DoTaskController {
    @Autowired
    private AsyncTask asyncTask;

//    public String doTask() throws Exception{
//
//        Future<Boolean> a = asyncTask.doTask();
//    }
}
