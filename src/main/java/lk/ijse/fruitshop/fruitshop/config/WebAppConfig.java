package lk.ijse.fruitshop.fruitshop.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.fruitshop.fruitshop")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.fruitshop.fruitshop")
@EnableTransactionManagement
@MultipartConfig(
        fileSizeThreshold = 102*1024*2,
        maxFileSize = 1024*1024*10,//10MB
        maxRequestSize = 1024*1024*50 //50MB
)
public class WebAppConfig {
}
