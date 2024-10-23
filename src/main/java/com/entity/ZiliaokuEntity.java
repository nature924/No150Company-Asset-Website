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
 * 资料库
 *
 * @author 
 * @email
 */
@TableName("ziliaoku")
public class ZiliaokuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZiliaokuEntity() {

	}

	public ZiliaokuEntity(T t) {
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
     * 资料编号
     */
    @ColumnInfo(comment="资料编号",type="varchar(200)")
    @TableField(value = "ziliaoku_uuid_number")

    private String ziliaokuUuidNumber;


    /**
     * 资料名称
     */
    @ColumnInfo(comment="资料名称",type="varchar(200)")
    @TableField(value = "ziliaoku_name")

    private String ziliaokuName;


    /**
     * 资料类型
     */
    @ColumnInfo(comment="资料类型",type="int(11)")
    @TableField(value = "ziliaoku_types")

    private Integer ziliaokuTypes;


    /**
     * 资料文件
     */
    @ColumnInfo(comment="资料文件",type="varchar(200)")
    @TableField(value = "ziliaoku_file")

    private String ziliaokuFile;


    /**
     * 资料介绍
     */
    @ColumnInfo(comment="资料介绍",type="longtext")
    @TableField(value = "ziliaoku_content")

    private String ziliaokuContent;


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
	 * 获取：资料编号
	 */
    public String getZiliaokuUuidNumber() {
        return ziliaokuUuidNumber;
    }
    /**
	 * 设置：资料编号
	 */

    public void setZiliaokuUuidNumber(String ziliaokuUuidNumber) {
        this.ziliaokuUuidNumber = ziliaokuUuidNumber;
    }
    /**
	 * 获取：资料名称
	 */
    public String getZiliaokuName() {
        return ziliaokuName;
    }
    /**
	 * 设置：资料名称
	 */

    public void setZiliaokuName(String ziliaokuName) {
        this.ziliaokuName = ziliaokuName;
    }
    /**
	 * 获取：资料类型
	 */
    public Integer getZiliaokuTypes() {
        return ziliaokuTypes;
    }
    /**
	 * 设置：资料类型
	 */

    public void setZiliaokuTypes(Integer ziliaokuTypes) {
        this.ziliaokuTypes = ziliaokuTypes;
    }
    /**
	 * 获取：资料文件
	 */
    public String getZiliaokuFile() {
        return ziliaokuFile;
    }
    /**
	 * 设置：资料文件
	 */

    public void setZiliaokuFile(String ziliaokuFile) {
        this.ziliaokuFile = ziliaokuFile;
    }
    /**
	 * 获取：资料介绍
	 */
    public String getZiliaokuContent() {
        return ziliaokuContent;
    }
    /**
	 * 设置：资料介绍
	 */

    public void setZiliaokuContent(String ziliaokuContent) {
        this.ziliaokuContent = ziliaokuContent;
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
        return "Ziliaoku{" +
            ", id=" + id +
            ", ziliaokuUuidNumber=" + ziliaokuUuidNumber +
            ", ziliaokuName=" + ziliaokuName +
            ", ziliaokuTypes=" + ziliaokuTypes +
            ", ziliaokuFile=" + ziliaokuFile +
            ", ziliaokuContent=" + ziliaokuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
