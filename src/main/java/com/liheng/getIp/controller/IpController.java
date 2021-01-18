package com.liheng.getIp.controller;

import com.liheng.getIp.ip.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IpController {
    @Autowired
    private HttpServletRequest servletRequest;
    @RequestMapping(value = "/ip",method = RequestMethod.GET)
    public Map getIp(){
        Map map = new HashMap();
        try {
            String requestIp = Util.getRequestIp(servletRequest);
            map.put("code",0);
            map.put("ip",requestIp);
        } catch (Exception e) {
            map.put("code","-1");
            map.put("msg","获取失败");
        }
        return map;
    }
}
