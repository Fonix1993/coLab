package com.fonix.colab.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 实验室日志表
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer labId;

    private String log;

    private String operaer;

    private LocalDateTime time;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "LabLog{" +
                "id=" + id +
                ", labId=" + labId +
                ", log='" + log + '\'' +
                ", operaer='" + operaer + '\'' +
                ", time=" + time +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
