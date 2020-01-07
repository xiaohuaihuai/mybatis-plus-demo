package com.example.mybatis.plus.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@RestController
@RequestMapping("/url")
public class UrlController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @GetMapping("/queryList")
    public ResponseEntity<List<String>> queryList(){
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        List<String> list = new ArrayList<>();
        for (RequestMappingInfo info : handlerMethods.keySet()){
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            list.addAll(patterns);
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/queryListDetail")
    public ResponseEntity<List<Map<String, String>>> queryListDetail(){
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        List<Map<String, String>> list = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : handlerMethods.entrySet()){
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();

            Map<String, String> map = new HashMap<>();
            map.put("ClassName", method.getMethod().getDeclaringClass().getName()); // 类名
            map.put("Method", method.getMethod().getName()); // 方法名
            for (RequestMethod requestMethod : info.getMethodsCondition().getMethods()) {
                map.put("RequestMethod", requestMethod.toString());
            }
            for (String url : info.getPatternsCondition().getPatterns()) {
                map.put("url", url);
            }

            list.add(map);
        }
        return ResponseEntity.ok(list);
    }
}
