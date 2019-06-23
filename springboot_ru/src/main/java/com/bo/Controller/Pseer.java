package com.bo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Pseer {
    @Value ( "${person.addr}" )
    private String sddr;
    @Value ( "${person.name}" )
    private String name;

    @RequestMapping("/zhang")
    @ResponseBody
    public String ko(){

        return "name" + name+",addr"+sddr;

    }
}
