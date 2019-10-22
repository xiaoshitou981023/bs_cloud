package cn.run.java.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author stone
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://127.0.0.1")
            .allowedMethods("PUT", "DELETE")
//            .allowedHeaders("")
//            .exposedHeaders("header1", "header2")
            .allowCredentials(true).maxAge(3600);
  }

}