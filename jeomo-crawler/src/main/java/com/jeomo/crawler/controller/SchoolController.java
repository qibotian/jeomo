package com.jeomo.crawler.controller;

import com.jeomo.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author: qbt
 * @Date: 2020/6/27 11:48
 * @Version 1.0
 */
@RestController
@RequestMapping("sc")
public class SchoolController {

    @Autowired
    CrawlerService service;

    @GetMapping("/{begin}/{end}")
    public void index(@PathVariable("begin") int begin, @PathVariable("end") int end) throws IOException {
        service.paqu(begin, end);
    }

}
