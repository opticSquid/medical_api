package com.sb.projects.java.spring.medical_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    //    public ModelAndView homeController(Locale locale) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("title","Clinic Manager");
//        mv.setViewName("home");
//        return mv;
//    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeController(ModelMap model) {
        model.put("title", "Clinic Manager");
        return "home";
    }
}
