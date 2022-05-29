package com.fonix.colab.controller.lab;


import com.fonix.colab.entity.LabActivity;
import com.fonix.colab.entity.LabActivityBlog;
import com.fonix.colab.service.LabActivityBlogService;
import com.fonix.colab.service.LabActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 实验室活动表 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Controller
@RequestMapping("/lab-activity")
public class LabActivityController {
    @Autowired
    LabActivityService labActivityService;
    @Autowired
    LabActivityBlogService labActivityBlogService;

    @GetMapping("/toActivity")
    public String toAcitivity(@RequestParam int labId, @RequestParam String userName, Model model) {
        List<LabActivity> activityList = labActivityService.selectByLabId(labId);
        model.addAttribute("activityList", activityList);
        model.addAttribute("labId", labId);
        model.addAttribute("userName", userName);
        return "/lab/activity/labActivity";
    }


    @GetMapping("/toCreate")
    public String toCreate(@RequestParam int labId, @RequestParam String userName, Model model) {
        model.addAttribute("labId", labId);
        model.addAttribute("userName", userName);
        return "/lab/activity/addActivity";
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(LabActivity labActivity, Model model) {
        labActivityService.create(labActivity);
        LabActivityBlog labActivityBlog = new LabActivityBlog();
        labActivityBlog.setActivityId(labActivity.getId());
        labActivityBlog.setTitle(labActivity.getTopic());
        labActivityBlogService.publishArticle(labActivityBlog);
        return "添加成功，请返回";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam int id, Model model) {
        LabActivity labActivity = labActivityService.getById(id);
        model.addAttribute("labActivity", labActivity);
        return "/lab/activity/updateActivity";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(LabActivity labActivity, Model model) {
        System.out.println(labActivity.toString());
        labActivityService.updateActivityById(labActivity);
        return "修改成功，请返回";
    }

    @GetMapping("/attend")
    @ResponseBody
    public String attend(@RequestParam String userName, @RequestParam int id, Model model) {
        LabActivity labActivity = labActivityService.getById(id);
        System.out.println(labActivity.getHoldTime());
        String attendee = labActivity.getAttendee();
        String msg = "";
        if (attendee == null) {
            labActivity.setAttendee(userName);
            msg = "你已成功报名该活动，请准时参加！";
        } else {
            if (attendee.contains(userName)) {
                msg = "你已报名该活动，请勿重复提交";
            } else {
                labActivity.setAttendee(labActivity.getAttendee() + ";" + userName);
                msg = "你已成功报名该活动，请准时参加！";
            }

        }
        labActivityService.updateActivityById(labActivity);
        return msg;
    }

    @GetMapping("/delete")
    public String deleteActivity(@RequestParam int id, @RequestParam int labId,@RequestParam String userName, Model model) {
        labActivityService.deleteById(id);
        List<LabActivity> activityList = labActivityService.selectByLabId(labId);
        model.addAttribute("activityList", activityList);
        model.addAttribute("labId", labId);
        model.addAttribute("userName", userName);
        return "/lab/activity/labActivity";
    }
}
