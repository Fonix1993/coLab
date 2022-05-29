package com.fonix.colab.controller.lab;


import com.fonix.colab.entity.LabActivityBlog;
import com.fonix.colab.service.LabActivityBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 活动日志表 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-27
 */
@Controller
@RequestMapping("/lab-activity-blog")
public class LabActivityBlogController {
    @Autowired
    LabActivityBlogService labActivityBlogServicel;

    @RequestMapping("/publish")
    @ResponseBody
    public String publishArticle(LabActivityBlog labActivityBlog) {
        boolean res = labActivityBlogServicel.publishArticle(labActivityBlog);
        if (res) {
            return "success";
        }
        return "false";
    }


    @RequestMapping("/get")
    public String getByActivityId(@RequestParam int activityId, Model model) {
        LabActivityBlog labActivityBlog = labActivityBlogServicel.getByActivityId(activityId);
        model.addAttribute("labActivityBlog",labActivityBlog);
        return "/lab/activity/article";
    }

    @RequestMapping("/toEdit")
    public String toEdit(@RequestParam int id, Model model) {
        LabActivityBlog labActivityBlog = labActivityBlogServicel.getById(id);
        model.addAttribute("labActivityBlog",labActivityBlog);
        return "/lab/activity/edit";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String editById(LabActivityBlog labActivityBlog) {
        System.out.println(labActivityBlog.toString());
        labActivityBlogServicel.updateBlogById(labActivityBlog);
        return "ok";
    }


}
