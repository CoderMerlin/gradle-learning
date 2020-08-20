package com.hm.cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Merlin
 * @Title: CmsController
 * @ProjectName gradle-learning
 * @Description: TODO
 * @date 2020/8/1914:05
 */


@RestController
@RequestMapping("cms")
public class CmsController {

    @RequestMapping("test")
    public String test(){
        return "成功访问cms系统！";
    }

}
