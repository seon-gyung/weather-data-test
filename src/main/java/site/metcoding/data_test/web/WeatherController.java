package site.metcoding.data_test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    
    @GetMapping("/")
    public String main(){
        return "/main";
    }
}
