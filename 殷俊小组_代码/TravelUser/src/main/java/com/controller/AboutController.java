package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @GetMapping("/getAboutDescription")
    public String getAboutDescription() {
        System.out.println("getAboutDescription");
        // 这里可以从数据库或者配置文件中读取简介内容
        String description = "欢迎来到我们的旅游网站——您的一站式旅游平台。我们致力于为全球旅行者提供最便捷、最丰富、最实惠的旅游服务...";
        return description;
    }
}
