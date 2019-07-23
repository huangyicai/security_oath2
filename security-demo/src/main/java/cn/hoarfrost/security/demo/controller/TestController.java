package cn.hoarfrost.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2019/7/23 15:32
 * @author: huangyicai
 * @descripe:
 * @version: 1.0
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String test1(){
        return "1111";
    }
}
