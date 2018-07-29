package com.djk.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import lombok.Data;

/**
 * Created by dujinkai on 2018/7/29.
 * 短信发送结果
 */
@Data
public class SmsResponse {

    /**
     * 发送结果 具体返回码详见阿里通讯文档
     * https://help.aliyun.com/document_detail/55284.html?spm=a2c4g.11186623.6.557.iY26jm
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 判断是否发送成功
     *
     * @return true  成功  false 失败
     */
    public boolean isSuccess() {
        return "OK".equals(this.code);
    }

    /**
     * 构造短信结果
     *
     * @param sendSmsResponse 短信结果
     * @return 返回短信结果
     */
    public static SmsResponse build(SendSmsResponse sendSmsResponse) {
        SmsResponse smsResponse = new SmsResponse();
        smsResponse.setCode(sendSmsResponse.getCode());
        smsResponse.setMessage(sendSmsResponse.getMessage());
        return smsResponse;
    }

    /**
     * 构造失败返回实体
     *
     * @return 返回失败返回实体
     */
    public static SmsResponse buildFail() {
        SmsResponse smsResponse = new SmsResponse();
        smsResponse.code = "Fail";
        smsResponse.setMessage("params error...");
        return smsResponse;
    }
}
