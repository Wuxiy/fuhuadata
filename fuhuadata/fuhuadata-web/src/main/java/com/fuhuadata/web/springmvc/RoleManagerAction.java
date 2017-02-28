package com.fuhuadata.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by intanswer on 2017/2/28.
 */
@Controller
@RequestMapping("/roleManager/*")
public class RoleManagerAction {

    @RequestMapping(value="/into",method = RequestMethod.GET)
    public ModelAndView RoleManager(){
        return new ModelAndView("system/systemCharacterEditor");
    }
}
