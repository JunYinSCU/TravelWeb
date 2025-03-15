package com;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String account, @RequestParam String password) {
        System.out.println("login account: " + account);
        System.out.println("login password: " + password);

        // 模拟登录逻辑
        JSONObject json = new JSONObject();

            json.put("status", "success");

        json.put("message", "登录成功");
        return json.toString(); // 返回JSON响应
    }
}
