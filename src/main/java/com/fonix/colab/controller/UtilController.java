package com.fonix.colab.controller;


import com.alibaba.fastjson.JSONObject;
import com.fonix.colab.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/util")
public class UtilController {

    @RequestMapping("/image/upload")
    @ResponseBody
    public JSONObject imageUpload(@RequestParam("editormd-image-file") MultipartFile image) {
        JSONObject jsonObject = new JSONObject();
        if(image != null) {
            String path = FileUtils.uploadFile(image);
            System.out.println(path);
            jsonObject.put("url", path);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success!");
            return jsonObject;
        }
        jsonObject.put("success", 0);
        jsonObject.put("message", "upload error!");
        return jsonObject;
    }
}
