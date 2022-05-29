package com.fonix.colab.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fonix.colab.entity.InfoUserandlab;

import java.util.List;

/**
 * <p>
 *  个人与实验室信息 服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
public interface InfoUserandlabService extends IService<InfoUserandlab> {

    void create(InfoUserandlab infoUserandlab);
    List<InfoUserandlab> selectLabsByUserName(String userName);
}
