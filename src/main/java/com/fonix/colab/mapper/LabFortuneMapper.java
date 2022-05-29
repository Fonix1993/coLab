package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabFortune;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  实验室财产表 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Repository
@Mapper
public interface LabFortuneMapper extends BaseMapper<LabFortune> {
    List<LabFortune> getFortuneByLabId(int labId);
    Integer create(LabFortune labFortune);
    LabFortune getFortuneById(int id);

    boolean updateFortuneById(LabFortune labFortune);
}
