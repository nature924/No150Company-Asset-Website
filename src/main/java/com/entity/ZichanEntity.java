package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 资产
 *
 * @author 
 * @email
 */
@TableName("zichan")
public class ZichanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZichanEntity() {

	}

	public ZichanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 资产编号
     */
    @ColumnInfo(comment="资产编号",type="varchar(200)")
    @TableField(value = "zichan_uuid_number")

    private String zichanUuidNumber;


    /**
     * 资产名称
     */
    @ColumnInfo(comment="资产名称",type="varchar(200)")
    @TableField(value = "zichan_name")

    private String zichanName;


    /**
     * 资产照片
     */
    @ColumnInfo(comment="资产照片",type="varchar(200)")
    @TableField(value = "zichan_photo")

    private String zichanPhoto;


    /**
     * 单位
     */
    @ColumnInfo(comment="单位",type="varchar(200)")
    @TableField(value = "zichan_danwei")

    private String zichanDanwei;


    /**
     * 资产类型
     */
    @ColumnInfo(comment="资产类型",type="int(11)")
    @TableField(value = "zichan_types")

    private Integer zichanTypes;


    /**
     * 资产数量
     */
    @ColumnInfo(comment="资产数量",type="int(11)")
    @TableField(value = "zichan_kucun_number")

    private Integer zichanKucunNumber;


    /**
     * 阈值
     */
    @ColumnInfo(comment="阈值",type="int(11)")
    @TableField(value = "zichan_yuzhi")

    private Integer zichanYuzhi;


    /**
     * 资产介绍
     */
    @ColumnInfo(comment="资产介绍",type="longtext")
    @TableField(value = "zichan_content")

    private String zichanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：资产编号
	 */
    public String getZichanUuidNumber() {
        return zichanUuidNumber;
    }
    /**
	 * 设置：资产编号
	 */

    public void setZichanUuidNumber(String zichanUuidNumber) {
        this.zichanUuidNumber = zichanUuidNumber;
    }
    /**
	 * 获取：资产名称
	 */
    public String getZichanName() {
        return zichanName;
    }
    /**
	 * 设置：资产名称
	 */

    public void setZichanName(String zichanName) {
        this.zichanName = zichanName;
    }
    /**
	 * 获取：资产照片
	 */
    public String getZichanPhoto() {
        return zichanPhoto;
    }
    /**
	 * 设置：资产照片
	 */

    public void setZichanPhoto(String zichanPhoto) {
        this.zichanPhoto = zichanPhoto;
    }
    /**
	 * 获取：单位
	 */
    public String getZichanDanwei() {
        return zichanDanwei;
    }
    /**
	 * 设置：单位
	 */

    public void setZichanDanwei(String zichanDanwei) {
        this.zichanDanwei = zichanDanwei;
    }
    /**
	 * 获取：资产类型
	 */
    public Integer getZichanTypes() {
        return zichanTypes;
    }
    /**
	 * 设置：资产类型
	 */

    public void setZichanTypes(Integer zichanTypes) {
        this.zichanTypes = zichanTypes;
    }
    /**
	 * 获取：资产数量
	 */
    public Integer getZichanKucunNumber() {
        return zichanKucunNumber;
    }
    /**
	 * 设置：资产数量
	 */

    public void setZichanKucunNumber(Integer zichanKucunNumber) {
        this.zichanKucunNumber = zichanKucunNumber;
    }
    /**
	 * 获取：阈值
	 */
    public Integer getZichanYuzhi() {
        return zichanYuzhi;
    }
    /**
	 * 设置：阈值
	 */

    public void setZichanYuzhi(Integer zichanYuzhi) {
        this.zichanYuzhi = zichanYuzhi;
    }
    /**
	 * 获取：资产介绍
	 */
    public String getZichanContent() {
        return zichanContent;
    }
    /**
	 * 设置：资产介绍
	 */

    public void setZichanContent(String zichanContent) {
        this.zichanContent = zichanContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Zichan{" +
            ", id=" + id +
            ", zichanUuidNumber=" + zichanUuidNumber +
            ", zichanName=" + zichanName +
            ", zichanPhoto=" + zichanPhoto +
            ", zichanDanwei=" + zichanDanwei +
            ", zichanTypes=" + zichanTypes +
            ", zichanKucunNumber=" + zichanKucunNumber +
            ", zichanYuzhi=" + zichanYuzhi +
            ", zichanContent=" + zichanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
