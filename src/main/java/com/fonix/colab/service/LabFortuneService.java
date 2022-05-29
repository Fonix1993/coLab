package com.fonix.colab.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fonix.colab.entity.LabFortune;

import java.util.List;

/**
 * <p>
 *  实验室财产表 服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
public interface LabFortuneService extends IService<LabFortune> {
    List<LabFortune> getFortuneByLabId(int labId);
    Integer create(LabFortune labFortune);

    Integer deleteById(LabFortune labFortune);
    boolean updateFortuneById(LabFortune labFortune);


    LabFortune getFortuneById(int id);
}
