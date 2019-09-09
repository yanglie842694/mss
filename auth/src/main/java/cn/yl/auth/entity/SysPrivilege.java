package cn.yl.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yanglie
 */
@Entity
@Table(name = "sys_privilege")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class SysPrivilege {

    @Column(name = "privi_id")
    @Id
    private Integer priviId;

    @Column(name = "privi_code")
    private String priviCode;

    @Column(name = "privi_name")
    private String priviName;

    @Column(name = "create_time")
    private Date createTime;

    public Integer getPriviId() {
        return priviId;
    }

    public void setPriviId(Integer priviId) {
        this.priviId = priviId;
    }

    public String getPriviCode() {
        return priviCode;
    }

    public void setPriviCode(String priviCode) {
        this.priviCode = priviCode;
    }

    public String getPriviName() {
        return priviName;
    }

    public void setPriviName(String priviName) {
        this.priviName = priviName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysPrivilege{" +
                "priviId=" + priviId +
                ", priviCode='" + priviCode + '\'' +
                ", priviName='" + priviName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
