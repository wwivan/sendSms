package com.sms.utils;

import com.sms.entity.VerifyCode;

import java.util.Random;

public class GetCode {
    private static VerifyCode verifyCode;

    /**
     * 生成短信验证码code
     */
    private static void getCode(){
        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        verifyCode = new VerifyCode(code);
    }

    /**
     * 判断是否存在code以及code值是否过期
     * @return
     */
    public static String getVerifyCode() {
        if(verifyCode==null||verifyCode.isExpired()) {
            getCode();
        }
        return verifyCode.getVerifyCode();
    }
}
