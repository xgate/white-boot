package me.xgate.accounts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cmoh on 2015. 9. 12..
 */
@RestController // = @Controller + @ResponseBody. api로 뱉어주는 최근에는 대부분 이걸로
public class AccountController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}