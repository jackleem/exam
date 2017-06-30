package com.free.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Li Yu on 2017/6/22.
 */
@RestController
public class TemplateController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(Map<String, Object> map){
        map.put("hello","from TempateController.hello");
        ModelAndView mav = new ModelAndView("hello");
        return mav;
    }

    @RequestMapping(value = "/play24", method = RequestMethod.GET)
    public ModelAndView play24Points(Map<String, Object> map){
        map.put("gameName","24 POINTS");
        map.put("tips","Input 4 numbers from 1 to 13:");
        map.put("submitBtn","PLAY!");
        ModelAndView mav = new ModelAndView("do24");
        return mav;
    }
}
