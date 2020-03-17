package com.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.sms.entity.Response;
import com.sms.entity.User;
import com.sms.service.SendSmsService;
import com.sms.utils.GetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms")
public class TestController {
    @Autowired
    SendSmsService sendSmsService;
    @RequestMapping("send")
    public Response sendSms(@RequestBody User req) throws Exception {
        String mobile = req.getMobile();
        JSONObject sms = sendSmsService.getSms(mobile);
        if(sms.getIntValue("code")!=0){
            return Response.failed(-1,"发送短信失败");
        }
        return Response.success("验证码发送成功");
    }

    @RequestMapping("verify")
    public Response verify(@RequestBody User req){
        String mobile = req.getMobile();
        String smsCode = req.getSmsCode();
        if(!smsCode.equals(GetCode.getVerifyCode())){
            return Response.failed(-1,"验证码输入错误或者已过期");
        }
        return Response.success("验证成功");
    }

    @RequestMapping("code")
    public Response code(){
        String verifyCode = GetCode.getVerifyCode();
        return Response.success(verifyCode);
    }
}
