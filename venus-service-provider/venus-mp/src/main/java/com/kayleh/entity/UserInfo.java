package com.kayleh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author kayleh
 * @since 2021-11-03
 */
@TableName("t_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("id")
    private Long id;

    /**
     * 名字
     */
    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("version")
    @Version
    private Integer version;

    /**
     * 标记删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    @TableField("create_id")
    private String createId;

    @TableField("create_name")
    private String createName;

    @TableField("update_id")
    private String updateId;

    @TableField("update_name")
    private String updateName;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }
    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", version=" + version +
            ", deleted=" + deleted +
            ", createId=" + createId +
            ", createName=" + createName +
            ", updateId=" + updateId +
            ", updateName=" + updateName +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
