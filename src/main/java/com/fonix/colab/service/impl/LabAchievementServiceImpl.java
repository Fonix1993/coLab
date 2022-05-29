package com.fonix.colab.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fonix.colab.entity.LabAchievement;
import com.fonix.colab.mapper.LabAchievementMapper;
import com.fonix.colab.service.LabAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 实验室成果 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Service
public class LabAchievementServiceImpl extends ServiceImpl<LabAchievementMapper, LabAchievement> implements LabAchievementService {
    @Autowired
    LabAchievementMapper labAchievementMapper;

    @Override
    public List<LabAchievement> selectByLabId(int labId) {
        return labAchievementMapper.selectByLabId(labId);
    }

    @Override
    public void deleteById(int id) {
        labAchievementMapper.deleteById(id);
    }

    @Override
    public void updateAchievementById(LabAchievement achievement) {
        labAchievementMapper.updateAchievementById(achievement);
    }

    @Override
    public LabAchievement selectById(int id) {
        return labAchievementMapper.selectById(id);
    }

    @Override
    public int create(LabAchievement labAchievement) {
        return labAchievementMapper.create(labAchievement);
    }
}
