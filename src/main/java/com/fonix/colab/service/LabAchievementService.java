package com.fonix.colab.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fonix.colab.entity.LabAchievement;

import java.util.List;

/**
 * <p>
 *  实验室成果 服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
public interface LabAchievementService extends IService<LabAchievement> {
    int create(LabAchievement labAchievement);
    List<LabAchievement> selectByLabId(int labId);

    void deleteById(int id);

    void updateAchievementById(LabAchievement achievement);

    LabAchievement selectById(int id);
}
