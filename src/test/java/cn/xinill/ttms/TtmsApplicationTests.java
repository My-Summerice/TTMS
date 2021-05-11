package cn.xinill.ttms;

import cn.xinill.ttms.pojo.Movie;
import cn.xinill.ttms.service.IMovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Stack;

@SpringBootTest
class TtmsApplicationTests {

    @Autowired
    IMovieService movieService;
    @Test
    void contextLoads() {
        System.out.println(555);
        
    }

}
