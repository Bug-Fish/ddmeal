package com.zjy.ddservice.controller;

import com.zjy.ddservice.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/ddservice/dd-user")
public class DdLoginController {

    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");

    }

    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");

    }


}
