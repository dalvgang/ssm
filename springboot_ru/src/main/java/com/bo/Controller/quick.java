package com.bo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class quick {
    @Value ( "${name}" )
    private String name;

        @RequestMapping("/wen")
        @ResponseBody
        public String Quick2Controller(){
           return"name"+name;
        }
}
