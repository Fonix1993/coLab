package com.fonix.colab.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  实验室成果
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabAchievement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer labId;

    private String achievement;

    private LocalDateTime time;

    private String introduction;

    private String achiever;

    private String operator;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;


}
