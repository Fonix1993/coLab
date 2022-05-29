package com.fonix.colab.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fonix.colab.entity.LabActivity;

import java.util.List;

/**
 * <p>
 * 实验室活动表 服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
public interface LabActivityService extends IService<LabActivity> {
    List<LabActivity> selectByLabId(int labID);
    void create(LabActivity labActivity);
    boolean updateActivityById(LabActivity labActivity);

    void deleteById(int id);
}
