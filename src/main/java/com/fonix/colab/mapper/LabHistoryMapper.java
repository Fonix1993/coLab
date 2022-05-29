package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.LabHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  实验室历史 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Repository
@Mapper
public interface LabHistoryMapper extends BaseMapper<LabHistory> {

}
