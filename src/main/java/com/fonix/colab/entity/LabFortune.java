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
 *  实验室财产表
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabFortune implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer labId;

    private String fortuneName;

    private String fortuneOwner;

    private String fortuneState;

    private String fortuneValue;

    private LocalDateTime purchaseTime;

    private LocalDateTime disableTime;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "LabFortune{" +
                "id=" + id +
                ", labId=" + labId +
                ", fortuneName='" + fortuneName + '\'' +
                ", fortuneOwner='" + fortuneOwner + '\'' +
                ", fortuneState='" + fortuneState + '\'' +
                ", fortuneValue='" + fortuneValue + '\'' +
                ", purchaseTime=" + purchaseTime +
                ", disableTime=" + disableTime +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
