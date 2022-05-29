package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabAchievement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  实验室成果 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Repository
@Mapper
public interface LabAchievementMapper extends BaseMapper<LabAchievement> {
    int create(LabAchievement labAchievement);
    List<LabAchievement> selectByLabId(int labId);
    void deleteById(int id);
    void updateAchievementById(LabAchievement achievement);
    LabAchievement selectById(int id);
}
