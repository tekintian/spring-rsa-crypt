package cn.tekin.rsacrypt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Springboot 配置信息读取
 *
 * @author tekintian@gmail.com
 * @version v0.0.1
 * @since v0.0.1 2022-03-14 14:19
 */
@Component
@ConfigurationProperties(prefix = "myapp.rsa")
@PropertySource(value = "classpath:application.yml")
@Data
public class AppConfig {

  private String rsaPublicKey;
  private String rsaPrivateKey;
  private String rsaBase64StrDemo;//demo用的


}
