package com.sms.service;

import com.alibaba.fastjson.JSONObject;
import com.sms.entity.VerifyCode;
import com.sms.utils.GetCode;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Service
public class SendSmsService {
    private static final String apiUrl = "https://sms_developer.zhenzikj.com";
    private static final String appId = "104865";
    private static final String appSecret = "9675269f-42f9-465c-a870-271b0fcbf05a";

    /**
     * 通过手机号获取验证码
     * @param mobile
     * @return
     * @throws Exception
     */
    public JSONObject getSms(String mobile) throws Exception {
        JSONObject json = null;
        String verifyCode = GetCode.getVerifyCode();
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        String result = client.send(mobile, "您的验证码为:" + verifyCode + "，该码有效期为5分钟，该码只能使用一次!");
        json = JSONObject.parseObject(result);
        return json;
    }
}
