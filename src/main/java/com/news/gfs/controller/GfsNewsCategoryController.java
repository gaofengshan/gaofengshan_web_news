package com.news.gfs.controller;

import com.github.pagehelper.PageInfo;
import com.news.gfs.pojo.GfsNewsCategory;
import com.news.gfs.service.GfsNewsCategoryService;
import com.news.gfs.service.GfsNewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class GfsNewsCategoryController {
    @Autowired
    private GfsNewsCategoryService gfsNewsCategoryService;
    @Autowired
    private GfsNewsInfoService gfsNewsInfoService;
    @RequestMapping("/checktype")
    @ResponseBody
    public Map<String, Object> checkTypeByName(String typeName) {
        GfsNewsCategory gfsNewsCategory = gfsNewsCategoryService.getTypeByName(typeName);
        Map<String, Object> result = new HashMap<>();
        if (gfsNewsCategory != null) {//当前类别已存在
            result.put("status", false);
            result.put("msg", "类别已存在,请更换名字");
        } else {
            result.put("status", true);
            result.put("msg", "类别名可以使用");
        }
        return result;
    }
    @RequestMapping("/add.html")
    public String regist(@Validated  GfsNewsCategory gfsNewsCategory, BindingResult result, HttpServletRequest request) {
        request.setAttribute("error", result);
        if (!result.hasErrors()) {
            gfsNewsCategoryService.doadd(gfsNewsCategory);
            return "redirect:list.html";
        }
        return "type/add";
    }
    @RequestMapping("/list.html")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "1") Integer pageNo) {
        PageInfo<GfsNewsCategory> typePage = gfsNewsCategoryService.gettypeList(pageNo);
        return new ModelAndView("type/list", "typePage", typePage);
    }
    @RequestMapping("/go_update.html")
    public String goupdate(Model model, @RequestParam(required = false) Integer id) throws Exception {
        GfsNewsCategory gfsNewsCategory = gfsNewsCategoryService.selectById(id);
        model.addAttribute("newsType", gfsNewsCategory);
        return "forward:/type/update.jsp";
    }
    @RequestMapping("/update.html")
    public String update(@Validated GfsNewsCategory gfsNewsCategory, BindingResult result, HttpServletRequest request) {
        request.setAttribute("error", result);
        if (!result.hasErrors()) {
            gfsNewsCategoryService.updateTypeInfo(gfsNewsCategory);
            return "redirect:/type/list.html";
        }
        return "type/update";
    }

    @RequestMapping("/delete.html")
    @ResponseBody
    public Map<String, Object> deletetype( Integer id) {
        gfsNewsCategoryService.deleteType(id);
        gfsNewsInfoService.deleteInfo(id);
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "删除成功");
        return result;
    }
//    @RequestMapping("/delete/{id}.html")
//    public String deletetype( @PathVariable Integer id) {
//        newsTypeService.deleteType(id);
//        return "redirect:/type/list.html";
//    }

}
