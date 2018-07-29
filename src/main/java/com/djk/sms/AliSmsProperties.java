package com.djk.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by dujinkai on 2018/7/29.
 * 阿里短信配置文件
 */
@ConfigurationProperties(
        prefix = "ali.sms"
)
@Data
public class AliSmsProperties {

    /**
     * 短信API产品名称（短信产品名固定，无需修改）
     */
    private String product = "Dysmsapi";

    /**
     * 短信API产品域名（接口地址固定，无需修改）
     */
    private String domain = "dysmsapi.aliyuncs.com";

    /**
     * 你的accessKeyId
     */
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;


}
