package com.news.gfs.controller;

import com.news.gfs.pojo.GfsNewsUser;
import com.news.gfs.service.GfsNewsUserService;
import com.news.gfs.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class GfsNewsUserController {
    @Autowired
    private GfsNewsUserService gfsNewsUserService;
    @RequestMapping("/checkuser.html")
    @ResponseBody
    public Map<String, Object> checkuserByName(String userName) {
        GfsNewsUser gfsNewsUser = gfsNewsUserService.getUserByName(userName);
        Map<String, Object> result = new HashMap<>();
        if (gfsNewsUser != null) {//当前用户已存在
            result.put("status", false);
            result.put("msg", "用户已存在,请更换名字");
        } else {
            result.put("status", true);
            result.put("msg", "用户名可以使用");
        }
        return result;
    }
    @RequestMapping("/regist.html")
    public String regist(@Validated GfsNewsUser gfsNewsUser, BindingResult result, String repwd, HttpServletRequest request) {
        request.setAttribute("error", result);
        if (!gfsNewsUser.getPassword().equals(repwd)) {
            return "error";
        }
        if (!result.hasErrors()) {
            gfsNewsUserService.doRegist(gfsNewsUser);
            return "login";
        }
        return "regist";
    }

    @RequestMapping("/login.html")
    public String login(String name, String password, HttpSession session) throws Exception {
       GfsNewsUser gfsNewsUser = gfsNewsUserService.doLogin(name, password);
        if(gfsNewsUser==null){
            session.setAttribute("msg","用户名或密码错误");
            return "login";
        }
        session.setAttribute(Constants.SESSION_USER, gfsNewsUser);
        return "success";
    }
    @RequestMapping("/logout.html")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/change.html")
    public String changeUser(HttpSession session,GfsNewsUser gfsNewsUser){
        gfsNewsUserService.changeUser(gfsNewsUser);
        Integer id = gfsNewsUser.getId();
        GfsNewsUser user = gfsNewsUserService.getUserById(id);
        session.setAttribute("user" ,user);
        return "userInfo";
    }
}
