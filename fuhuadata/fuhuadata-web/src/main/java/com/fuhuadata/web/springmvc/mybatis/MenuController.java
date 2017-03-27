package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>User: wangjie
 * <p>Date: 3/24/2017
 */
@Controller
@RequestMapping("/sys/menu")
public class MenuController extends BaseTreeableController<Menu, Integer> {

    @RequestMapping(value = {"", "init"}, method = RequestMethod.GET)
    public String mian() {
        return "";
    }

}
