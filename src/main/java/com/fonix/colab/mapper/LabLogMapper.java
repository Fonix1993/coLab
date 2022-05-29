package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 实验室日志表 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Repository
@Mapper
public interface LabLogMapper extends BaseMapper<LabLog> {

}
