package cn.edu.zafu.subjectbuild.frame.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
* @date 2020-4-8
* @author cyk
* Druid配置
* */
@Data
@Component
@ConfigurationProperties(prefix = "subject.build.druid",ignoreUnknownFields = true)
public class DruidConfig {
    /*登录用户名*/
    private String loginUsername;
    /*登录密码*/
    private String loginPassword;
}
