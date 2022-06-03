package com.stmanagment.sts.controller;

import com.stmanagment.sts.service.UnirestApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Jira")
public class JiraApiController {
    
    @Autowired
    UnirestApiService unirestApiService;

    @GetMapping("/project")
    public Object getJiraProjects() throws Exception{
        return unirestApiService.GetUnirestApiResponse();
    }
}
