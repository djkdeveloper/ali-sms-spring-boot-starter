package com.djk.sms;

import lombok.Data;

/**
 * Created by dujinkai on 2018/7/29.
 * 短信发送请求
 */
@Data
public class SmsRequest {

    /**
     * 待发送手机号 多个号码用，分开
     */
    private String sendNumbers;

    /**
     * 短信签名
     */
    private String signName;

    /**
     * 模版号
     */
    private String templateCode;

    /**
     * 模板中的变量替换JSON串
     */
    private String templateParam;

    /**
     * 扩展字段,最终在短信回执消息中将此值带回给调用者
     */
    private String outId;
}
