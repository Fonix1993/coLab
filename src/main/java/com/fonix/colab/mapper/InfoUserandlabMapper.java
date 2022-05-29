package com.fonix.colab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fonix.colab.entity.InfoUserandlab;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  个人与实验室信息 Mapper 接口
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
@Repository
@Mapper
public interface InfoUserandlabMapper extends BaseMapper<InfoUserandlab> {
    void create(InfoUserandlab infoUserandlab);
    List<InfoUserandlab> selectLabsByUserName(String userName);
}
