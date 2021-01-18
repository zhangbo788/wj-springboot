package top.zbawq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.zbawq.mapper")
public class WjSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjSpringbootApplication.class, args);
    }

}
