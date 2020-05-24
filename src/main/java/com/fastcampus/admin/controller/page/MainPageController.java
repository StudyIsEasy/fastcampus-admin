package com.fastcampus.admin.controller.page;

import com.fastcampus.admin.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path={"/","/pages"})
public class MainPageController {

    private final AdminMenuService adminMenuService;

    @Autowired
    public MainPageController(AdminMenuService adminMenuService) {
        this.adminMenuService = adminMenuService;
    }

    @RequestMapping(path = {"","/main"})
    public ModelAndView main(){
        return new ModelAndView("/pages/main")
                .addObject("menuList", adminMenuService.getAdminMenu())
                .addObject("code", "main")
                ;
    }


}
