package com.djk.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dujinkai on 2018/7/29.
 * 阿里短信自动配置类
 */
@Configuration
@ConditionalOnClass({SendSmsRequest.class})
@EnableConfigurationProperties({AliSmsProperties.class})
public class AliSmsAutoConfig {

    @Bean
    public AliSmsTemplate aliSmsTemplate(AliSmsProperties aliSmsProperties) {
        try {
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliSmsProperties.getAccessKeyId(),
                    aliSmsProperties.getAccessKeySecret());
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", aliSmsProperties.getProduct(), aliSmsProperties.getDomain());
            return new AliSmsTemplate(new DefaultAcsClient(profile));
        } catch (Exception e) {
            throw new RuntimeException("init alisms fail...", e);
        }
    }
}
