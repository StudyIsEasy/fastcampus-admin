package com.fastcampus.admin.controller.page;

import com.fastcampus.admin.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path={"/","/pages/student"})
public class StudentPageController {

    private final AdminMenuService adminMenuService;

    @Autowired
    public StudentPageController(AdminMenuService adminMenuService) {
        this.adminMenuService = adminMenuService;
    }

    @RequestMapping(path = {""})
    public ModelAndView student(){
        return new ModelAndView("/pages/student/student")
                .addObject("menuList", adminMenuService.getAdminMenu())
                .addObject("code", "student")
                ;
    }

    @RequestMapping(path = {"/view"})
    public ModelAndView view(){
        return new ModelAndView("/pages/student/view");
    }
}
