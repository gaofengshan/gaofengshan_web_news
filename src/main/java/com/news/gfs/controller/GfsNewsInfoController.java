package com.news.gfs.controller;

import com.github.pagehelper.PageInfo;
import com.news.gfs.pojo.GfsCriteria.GfsCriteria;
import com.news.gfs.pojo.GfsNewsCategory;
import com.news.gfs.pojo.GfsNewsInfo;
import com.news.gfs.service.GfsNewsCategoryService;
import com.news.gfs.service.GfsNewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/info")
public class GfsNewsInfoController {
    @Autowired
    private GfsNewsInfoService gfsNewsInfoService;
    @Autowired
    private GfsNewsCategoryService gfsNewsCategoryService;

    @RequestMapping("/go_{page}.html")
    public String goAdd(Model model, @PathVariable String page, @RequestParam(required = false) Integer id) throws Exception {
        List<GfsNewsCategory> list = gfsNewsCategoryService.getAllType();
        model.addAttribute("typeList", list);
        if ("update".equals(page) && id != null) {//修改
            GfsNewsInfo gfsNewsInfo = gfsNewsInfoService.selectById(id);
            model.addAttribute("newsInfo", gfsNewsInfo);
        }
        return "news/" + page;
    }
    @RequestMapping("/add.html")
    public String add(@Validated GfsNewsInfo gfsNewsInfo, BindingResult result, HttpServletRequest request) {
        request.setAttribute("error", result);
        if (!result.hasErrors()) {
            gfsNewsInfoService.addNewsInfo(gfsNewsInfo);
            return "redirect:/info/list.html";
        }
        List<GfsNewsCategory> list = null;
        try {
            list = gfsNewsCategoryService.getAllType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("typeList", list);
        return "news/add";
    }

    @RequestMapping("/list.html")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "1") Integer pageNo, GfsCriteria gfsNewsInfo, Model model) {
        PageInfo<GfsNewsInfo> infoList = gfsNewsInfoService.getInfoList(gfsNewsInfo,pageNo);
        List<GfsNewsCategory> typeList = gfsNewsCategoryService.getAllType();
        model.addAttribute("infoList",infoList);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("news/list");
    }
    @RequestMapping("newsInfo.html")
    public ModelAndView goInfo( Integer id ) {
        GfsNewsInfo gfsNewsInfo = gfsNewsInfoService.getInfoById(id);
        return new ModelAndView("news/info","newsInfo",gfsNewsInfo);

    }
//
//    @RequestMapping("/delete/{id}.html")
//    public String deleteemployee( @PathVariable Integer id) {
//        employeeService.deleteEmployee(id);
//        return "redirect:/employee/list.html";
//    }


}

