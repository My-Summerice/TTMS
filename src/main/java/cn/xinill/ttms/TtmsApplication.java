package cn.xinill.ttms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TtmsApplication {

    public static void main(String[] args) {
        System.out.println("启动部署");
        SpringApplication.run(TtmsApplication.class, args);
        System.out.println("部署完毕");
    }

}
