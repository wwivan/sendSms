package com.sms.entity;

public class VerifyCode {
    private String verifyCode;
    private long expireTime;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public VerifyCode(String verifyCode) {
        super();
        this.verifyCode = verifyCode;
        expireTime = System.currentTimeMillis()+1000*60*5;
    }

    /**
     *
     */
    public boolean isExpired() {
        return System.currentTimeMillis()>expireTime;
    }
}
