package ru.geekbrains.testBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }
    @GetMapping("/error")
    public String showErrorPage() {
        return "error_page";
    }


    @RequestMapping("/admin/onlyYou")
    @ResponseBody
    public String onlyYou() {
        return "123344567";
    }

}
