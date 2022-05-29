package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabActivity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 实验室活动表 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Repository
@Mapper
public interface LabActivityMapper extends BaseMapper<LabActivity> {
    List<LabActivity> selectByLabId(int labID);
    void create(LabActivity labActivity);
    boolean updateActivityById(LabActivity labActivity);
}
