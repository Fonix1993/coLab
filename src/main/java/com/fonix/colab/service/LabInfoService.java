package com.fonix.colab.service;

import com.fonix.colab.entity.LabInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 实验室信息表 服务类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
public interface LabInfoService extends IService<LabInfo> {
     public Integer create(LabInfo labInfo);
     List<LabInfo> searchByIdorName(String value);
     LabInfo selectByName(String labName);
}
