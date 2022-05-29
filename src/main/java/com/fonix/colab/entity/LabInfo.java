package com.fonix.colab.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 实验室信息表
 * </p>
 *
 * @author Fonix
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("labNum")
    private String labNum;

    private String name;

    private String type;

    @TableField("peopleCount")
    private Integer peopleCount;

    private String address;

    @TableField("positionCount")
    private Integer positionCount;

    private String mentor;

    private String creator;

    private String manager;

    private LocalDateTime creatTime;

    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "LabInfo{" +
                "id=" + id +
                ", labNum='" + labNum + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", peopleCount=" + peopleCount +
                ", address='" + address + '\'' +
                ", positionCount=" + positionCount +
                ", mentor='" + mentor + '\'' +
                ", creator='" + creator + '\'' +
                ", manager='" + manager + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
