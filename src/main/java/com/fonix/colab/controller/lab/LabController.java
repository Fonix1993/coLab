package com.fonix.colab.controller.lab;

import com.fonix.colab.entity.InfoUserandlab;
import com.fonix.colab.entity.LabInfo;
import com.fonix.colab.service.InfoUserandlabService;
import com.fonix.colab.service.LabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lab")
public class LabController {
    @Autowired
    LabInfoService labInfoService;
    @Autowired
    InfoUserandlabService infoUserandlabService;
    @GetMapping("/addLab")
    public String addLab(@RequestParam String userName, Model model) {
        model.addAttribute("userName", userName);
        return "/lab/addNewLab";
    }

    @GetMapping("/enterLab")
    public String enterLab(@RequestParam int labId, @RequestParam String userName, Model model) {
        model.addAttribute("labId", labId);
        model.addAttribute("userName", userName);
        return "/lab/labIndex";
    }

    @GetMapping("/toApplyEnterLab")
    public String toApplyEnterLab(@RequestParam String userName, Model model) {
        model.addAttribute("userName", userName);
        return "/lab/labApply";
    }

    @PostMapping("/searchLab")
    public String searchLab(
            @RequestParam String userName,
            @RequestParam String value,
            Model model) {
        System.out.println(userName + "   " + value);
        List<LabInfo> labList = labInfoService.searchByIdorName(value);
        model.addAttribute("userName", userName);
        model.addAttribute("labList", labList);
        return "/lab/labApply";
    }


    @PostMapping(value = "/create")
    @ResponseBody
    public String create(LabInfo labInfo,@RequestParam String userName) {
        labInfo.setCreator(userName);
        labInfoService.create(labInfo);
        LabInfo labInfo1 = labInfoService.selectByName(labInfo.getName());
        InfoUserandlab infoUserandlab = new InfoUserandlab();
        infoUserandlab.setLabName(labInfo.getName());
        infoUserandlab.setLabId(labInfo1.getId());
        infoUserandlab.setUserName(userName);
        infoUserandlab.setPermission("creator");
        infoUserandlabService.create(infoUserandlab);
        return "实验室创建成功";
    }
}
