package com.fonix.colab.controller.lab;


import com.fonix.colab.entity.LabAchievement;
import com.fonix.colab.service.LabAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 实验室成果 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Controller
@RequestMapping("/lab-achievement")
public class LabAchievementController {
    @Autowired
    LabAchievementService labAchievementService;
    @GetMapping("/toLabAchievement")
    public String toLabAchievemen(@RequestParam int labId, Model model) {
        List<LabAchievement> achievementList = labAchievementService.selectByLabId(labId);
        model.addAttribute("achievementList",achievementList);
        model.addAttribute("labId", labId);
        return "/lab/achievement/labAchievement";
    }

    @GetMapping("/toCreate")
    public String toCreate(@RequestParam int labId, Model model) {
        model.addAttribute("labId", labId);
        return "/lab/achievement/addAchievement";
    }

    @PostMapping("/create")
    @ResponseBody
    public String Create(LabAchievement achievement, Model model) {
        labAchievementService.create(achievement);
        return "添加成功，请返回";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, @RequestParam int labId, Model model) {
        labAchievementService.deleteById(id);
        List<LabAchievement> achievementList = labAchievementService.selectByLabId(labId);
        model.addAttribute("achievementList",achievementList);
        model.addAttribute("labId", labId);
        return "/lab/achievement/labAchievement";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateAchievementById(LabAchievement achievement) {
        labAchievementService.updateAchievementById(achievement);
        return "财产更新成功，请返回";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam int id, Model model) {
        LabAchievement labAchievement = labAchievementService.selectById(id);
        model.addAttribute("labAchievement",labAchievement);
        return "/lab/achievement/updateAchievement";
    }

}
