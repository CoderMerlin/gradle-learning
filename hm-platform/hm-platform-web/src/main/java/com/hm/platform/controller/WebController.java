package com.hm.platform.controller;

import com.hm.platform.common.CommonTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Merlin
 * @Title: WebController
 * @ProjectName gradle-learning
 * @Description: TODO
 * @date 2020/8/2410:52
 */
@RestController
@RequestMapping("web")
public class WebController {


    @RequestMapping("/test")
    public String test(){
        return CommonTest.commonTest();
    }

}
