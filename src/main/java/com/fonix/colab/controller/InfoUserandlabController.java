package com.fonix.colab.controller;


import com.fonix.colab.entity.InfoUserandlab;
import com.fonix.colab.service.InfoUserandlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  个人与实验室信息 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/info-userandlab")
public class InfoUserandlabController {
    @Autowired
    InfoUserandlabService infoUserandlabService;

    @GetMapping("/add")
    @ResponseBody
    public String add(
            @RequestParam int labId,
            @RequestParam String userName,
            @RequestParam String labName
    ) {
        InfoUserandlab infoUserandlab = new InfoUserandlab();
        infoUserandlab.setLabId(labId);
        infoUserandlab.setLabName(labName);
        infoUserandlab.setUserName(userName);
        infoUserandlab.setPermission("member");
        infoUserandlabService.create(infoUserandlab);
        return "申请成功";
    }

    @GetMapping("/selectByuserName")
    @ResponseBody
    public String selectByuserName(@RequestParam String userName) {
        List<InfoUserandlab> list = infoUserandlabService.selectLabsByUserName(userName);
        return list.toString();
    }


}
