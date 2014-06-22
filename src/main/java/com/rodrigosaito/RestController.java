package com.rodrigosaito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ConfigurableBean configurableBean;

    @RequestMapping("/config1")
    public String config1() {
        return configurableBean.getConfig1();
    }

    @RequestMapping("config2")
    public Integer config2() {
        return configurableBean.getConfig2();
    }

}
