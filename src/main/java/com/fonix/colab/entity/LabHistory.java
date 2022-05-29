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
 *  实验室历史
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer labId;

    private String event;

    private LocalDateTime time;

    private String introduction;

    private String operator;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;


}
