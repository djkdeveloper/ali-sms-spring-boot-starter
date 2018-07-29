# ali-sms-spring-boot-starter
阿里短信开箱即用

## 介绍
使用的是阿里通讯短信 首先要去阿里通讯注册账号 https://dysms.console.aliyun.com/dysms.htm 具体过程参照阿里云通讯文档

该项目提供了开箱即用的功能

## 使用方法
在本地把项目下下来 git clone https://github.com/djkdeveloper/ali-sms-spring-boot-starter.git

下下来后执行mvn clean install 命令 在本地安装jar包 （可以把打出来的jar  放到自己的私服上方便公司其他人使用）

在自己的项目maven的pom文件中导入该项目


```bash
     <dependency>
            <groupId>com.djk</groupId>
            <artifactId>ali-sms-spring-boot-starter</artifactId>
            <version>0.0.1-SNAPSHOT</version>
     </dependency>
```

在配置文件中配置key和秘钥

```bash
  ali.sms.accessKeyId=111
  ali.sms.accessKeySecret=2222
```

然后引入发送短信模版接口 如下发送即口
```bash
@RestController
public class SmsController {

    @Autowired
    private AliSmsTemplate aliSmsTemplate;

    @RequestMapping("/smstest")
    public SmsResponse sendSms() {

        SmsRequest smsRequest = new SmsRequest();
        // 设置签名
        smsRequest.setSignName("身份验证");
        // 设置模版code
        smsRequest.setTemplateCode("SMS_94405044");
        //待发送手机号 多个号码用，分开
        smsRequest.setSendNumbers("15195812211,15195812212");
        // 模板中的变量替换JSON串
        smsRequest.setTemplateParam("{\"code\":\"123456\"}");
        SmsResponse smsResponse = aliSmsTemplate.sendSms(smsRequest);

        // 判断短信是否发送成功
        smsResponse.isSuccess();
        return smsResponse;
    }
}

```

判断短信是否发送成功可以调用smsResponse.isSuccess() 来进行判断

