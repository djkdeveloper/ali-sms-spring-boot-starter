package com.djk.sms;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.http.MethodType;

import java.util.Objects;

/**
 * Created by dujinkai on 2018/7/29.
 * 阿里短信发送模版
 */
public class AliSmsTemplate {

    /**
     * 发送短信客户端
     */
    private IAcsClient acsClient;

    public AliSmsTemplate(IAcsClient acsClient) {
        this.acsClient = acsClient;
    }

    /**
     * 发送短信
     *
     * @param smsRequest 短信参数
     * @return 返回
     */
    public SmsResponse sendSms(SmsRequest smsRequest) {
        if (Objects.isNull(smsRequest)) {
            return SmsResponse.buildFail();
        }
        try {
            return SmsResponse.build(acsClient.getAcsResponse(getSendSmsRequest(smsRequest)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SmsResponse.buildFail();
    }


    /**
     * 获得短信请求参数
     *
     * @return 返回短信请求参数
     */
    private SendSmsRequest getSendSmsRequest(SmsRequest smsRequest) {
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setMethod(MethodType.POST);
        sendSmsRequest.setPhoneNumbers(smsRequest.getSendNumbers());
        sendSmsRequest.setSignName(smsRequest.getSignName());
        sendSmsRequest.setTemplateCode(smsRequest.getTemplateCode());
        sendSmsRequest.setTemplateParam(smsRequest.getTemplateParam());
        sendSmsRequest.setOutId(smsRequest.getOutId());
        return sendSmsRequest;
    }


}
