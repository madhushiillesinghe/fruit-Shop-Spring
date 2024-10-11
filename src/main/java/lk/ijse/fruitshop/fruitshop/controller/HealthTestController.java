package lk.ijse.fruitshop.fruitshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/fruits/health")
public class HealthTestController {
    static Logger logger = LoggerFactory.getLogger(HealthTestController.class);
    @GetMapping
    public String healthCheck(){
        logger.info("Spring POS API is running");
        return "Spring POS API is running";
    }
}
