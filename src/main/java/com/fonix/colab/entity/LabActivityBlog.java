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
 *  活动日志表
 * </p>
 *
 * @author Fonix
 * @since 2022-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabActivityBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer activityId;

    private String title;

    private String content;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;


}
