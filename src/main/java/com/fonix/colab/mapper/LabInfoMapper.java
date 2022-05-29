package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 实验室信息表 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Repository
@Mapper
public interface LabInfoMapper extends BaseMapper<LabInfo> {
    Integer create(LabInfo labInfo);
    List<LabInfo> searchByIdorName(String value);
    LabInfo selectByName(String labName);
}
