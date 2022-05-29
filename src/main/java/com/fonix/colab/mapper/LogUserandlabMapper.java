package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LogUserandlab;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  个人与实验室相关日志 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
@Repository
@Mapper
public interface LogUserandlabMapper extends BaseMapper<LogUserandlab> {

}
