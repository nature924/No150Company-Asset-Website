package com.entity.model;

import com.entity.ZichanShenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZichanShenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 资产
     */
    private Integer zichanId;


    /**
     * 资产申请编号
     */
    private String zichanShenqingUuidNumber;


    /**
     * 资产申请类型
     */
    private Integer zichanShenqingTypes;


    /**
     * 资产申请数量
     */
    private Integer zichanShenqingKucunNumber;


    /**
     * 申请缘由
     */
    private String zichanShenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer zichanShenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String zichanShenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zichanShenqingShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：资产
	 */
    public Integer getZichanId() {
        return zichanId;
    }


    /**
	 * 设置：资产
	 */
    public void setZichanId(Integer zichanId) {
        this.zichanId = zichanId;
    }
    /**
	 * 获取：资产申请编号
	 */
    public String getZichanShenqingUuidNumber() {
        return zichanShenqingUuidNumber;
    }


    /**
	 * 设置：资产申请编号
	 */
    public void setZichanShenqingUuidNumber(String zichanShenqingUuidNumber) {
        this.zichanShenqingUuidNumber = zichanShenqingUuidNumber;
    }
    /**
	 * 获取：资产申请类型
	 */
    public Integer getZichanShenqingTypes() {
        return zichanShenqingTypes;
    }


    /**
	 * 设置：资产申请类型
	 */
    public void setZichanShenqingTypes(Integer zichanShenqingTypes) {
        this.zichanShenqingTypes = zichanShenqingTypes;
    }
    /**
	 * 获取：资产申请数量
	 */
    public Integer getZichanShenqingKucunNumber() {
        return zichanShenqingKucunNumber;
    }


    /**
	 * 设置：资产申请数量
	 */
    public void setZichanShenqingKucunNumber(Integer zichanShenqingKucunNumber) {
        this.zichanShenqingKucunNumber = zichanShenqingKucunNumber;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getZichanShenqingContent() {
        return zichanShenqingContent;
    }


    /**
	 * 设置：申请缘由
	 */
    public void setZichanShenqingContent(String zichanShenqingContent) {
        this.zichanShenqingContent = zichanShenqingContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getZichanShenqingYesnoTypes() {
        return zichanShenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setZichanShenqingYesnoTypes(Integer zichanShenqingYesnoTypes) {
        this.zichanShenqingYesnoTypes = zichanShenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getZichanShenqingYesnoText() {
        return zichanShenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setZichanShenqingYesnoText(String zichanShenqingYesnoText) {
        this.zichanShenqingYesnoText = zichanShenqingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getZichanShenqingShenheTime() {
        return zichanShenqingShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setZichanShenqingShenheTime(Date zichanShenqingShenheTime) {
        this.zichanShenqingShenheTime = zichanShenqingShenheTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
