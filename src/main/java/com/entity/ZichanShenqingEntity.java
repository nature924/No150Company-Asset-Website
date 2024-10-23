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
 * 资产申请
 *
 * @author 
 * @email
 */
@TableName("zichan_shenqing")
public class ZichanShenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZichanShenqingEntity() {

	}

	public ZichanShenqingEntity(T t) {
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
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 资产
     */
    @ColumnInfo(comment="资产",type="int(11)")
    @TableField(value = "zichan_id")

    private Integer zichanId;


    /**
     * 资产申请编号
     */
    @ColumnInfo(comment="资产申请编号",type="varchar(200)")
    @TableField(value = "zichan_shenqing_uuid_number")

    private String zichanShenqingUuidNumber;


    /**
     * 资产申请类型
     */
    @ColumnInfo(comment="资产申请类型",type="int(11)")
    @TableField(value = "zichan_shenqing_types")

    private Integer zichanShenqingTypes;


    /**
     * 资产申请数量
     */
    @ColumnInfo(comment="资产申请数量",type="int(11)")
    @TableField(value = "zichan_shenqing_kucun_number")

    private Integer zichanShenqingKucunNumber;


    /**
     * 申请缘由
     */
    @ColumnInfo(comment="申请缘由",type="longtext")
    @TableField(value = "zichan_shenqing_content")

    private String zichanShenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "zichan_shenqing_yesno_types")

    private Integer zichanShenqingYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "zichan_shenqing_yesno_text")

    private String zichanShenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "zichan_shenqing_shenhe_time")

    private Date zichanShenqingShenheTime;


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

    @Override
    public String toString() {
        return "ZichanShenqing{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", zichanId=" + zichanId +
            ", zichanShenqingUuidNumber=" + zichanShenqingUuidNumber +
            ", zichanShenqingTypes=" + zichanShenqingTypes +
            ", zichanShenqingKucunNumber=" + zichanShenqingKucunNumber +
            ", zichanShenqingContent=" + zichanShenqingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", zichanShenqingYesnoTypes=" + zichanShenqingYesnoTypes +
            ", zichanShenqingYesnoText=" + zichanShenqingYesnoText +
            ", zichanShenqingShenheTime=" + DateUtil.convertString(zichanShenqingShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
