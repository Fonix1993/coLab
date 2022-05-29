package com.fonix.colab.controller.lab;


import com.fonix.colab.entity.LabFortune;
import com.fonix.colab.service.LabFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  实验室财产表 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Controller
@RequestMapping("/lab-fortune")
public class LabFortuneController {

    @Autowired
    LabFortuneService labFortuneService;
    @PostMapping("/create")
    @ResponseBody
    public String create(LabFortune labFortune) {
        labFortuneService.create(labFortune);
        return "财产添加成功，请返回";
    }
    @GetMapping("/delete")
    public String delete(LabFortune labFortune,Model model) {
        labFortuneService.deleteById(labFortune);
        List<LabFortune> fortuneList = labFortuneService.getFortuneByLabId(labFortune.getLabId());
        model.addAttribute("fortuneList", fortuneList);
        model.addAttribute("labId", labFortune.getLabId());
        return "/lab/fortune/labFortune";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateFortuneById(LabFortune labFortune) {
        labFortuneService.updateFortuneById(labFortune);
        return "财产更新成功，请返回";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam int id, Model model) {
        LabFortune labFortune = labFortuneService.getFortuneById(id);
        model.addAttribute(labFortune);
        return "/lab/fortune/updateFortune";
    }

    @GetMapping("/toCreate")
    public String toCreate(@RequestParam int labId, Model model) {
        model.addAttribute("labId", labId);
        return "/lab/fortune/addNewFortune";
    }
    @GetMapping("/toLabFortune")
    public String toLabFortune(@RequestParam int labId, Model model) {
        List<LabFortune> fortuneList = labFortuneService.getFortuneByLabId(labId);
        model.addAttribute("fortuneList", fortuneList);
        model.addAttribute("labId", labId);
        return "/lab/fortune/labFortune";
    }

}
