package com.zhuyi.studying.controller;

import com.zhuyi.domain.Test1;
import com.zhuyi.domain.Test2;
import com.zhuyi.studying.common.BaseController;
import com.zhuyi.utils.ClassFactoryUtils;
import com.zhuyi.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @ResponseBody
    @RequestMapping(value="test1", method={RequestMethod.GET, RequestMethod.POST})
    public String test1(){
        Test1 test1 = ClassFactoryUtils.createObject(Test1.class, Test2.class);
        String test1Json = JsonUtils.toJson(test1);
        return test1Json;
    }



}
