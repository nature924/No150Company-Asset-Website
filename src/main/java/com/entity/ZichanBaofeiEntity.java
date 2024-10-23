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
 * 资产报废
 *
 * @author 
 * @email
 */
@TableName("zichan_baofei")
public class ZichanBaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZichanBaofeiEntity() {

	}

	public ZichanBaofeiEntity(T t) {
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
     * 资产报废编号
     */
    @ColumnInfo(comment="资产报废编号",type="varchar(200)")
    @TableField(value = "zichan_baofei_uuid_number")

    private String zichanBaofeiUuidNumber;


    /**
     * 资产报废类型
     */
    @ColumnInfo(comment="资产报废类型",type="int(11)")
    @TableField(value = "zichan_baofei_types")

    private Integer zichanBaofeiTypes;


    /**
     * 资产报废数量
     */
    @ColumnInfo(comment="资产报废数量",type="int(11)")
    @TableField(value = "zichan_baofei_kucun_number")

    private Integer zichanBaofeiKucunNumber;


    /**
     * 报废缘由
     */
    @ColumnInfo(comment="报废缘由",type="longtext")
    @TableField(value = "zichan_baofei_content")

    private String zichanBaofeiContent;


    /**
     * 报废时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报废时间",type="timestamp")
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
	 * 获取：资产报废编号
	 */
    public String getZichanBaofeiUuidNumber() {
        return zichanBaofeiUuidNumber;
    }
    /**
	 * 设置：资产报废编号
	 */

    public void setZichanBaofeiUuidNumber(String zichanBaofeiUuidNumber) {
        this.zichanBaofeiUuidNumber = zichanBaofeiUuidNumber;
    }
    /**
	 * 获取：资产报废类型
	 */
    public Integer getZichanBaofeiTypes() {
        return zichanBaofeiTypes;
    }
    /**
	 * 设置：资产报废类型
	 */

    public void setZichanBaofeiTypes(Integer zichanBaofeiTypes) {
        this.zichanBaofeiTypes = zichanBaofeiTypes;
    }
    /**
	 * 获取：资产报废数量
	 */
    public Integer getZichanBaofeiKucunNumber() {
        return zichanBaofeiKucunNumber;
    }
    /**
	 * 设置：资产报废数量
	 */

    public void setZichanBaofeiKucunNumber(Integer zichanBaofeiKucunNumber) {
        this.zichanBaofeiKucunNumber = zichanBaofeiKucunNumber;
    }
    /**
	 * 获取：报废缘由
	 */
    public String getZichanBaofeiContent() {
        return zichanBaofeiContent;
    }
    /**
	 * 设置：报废缘由
	 */

    public void setZichanBaofeiContent(String zichanBaofeiContent) {
        this.zichanBaofeiContent = zichanBaofeiContent;
    }
    /**
	 * 获取：报废时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：报废时间
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
        return "ZichanBaofei{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", zichanId=" + zichanId +
            ", zichanBaofeiUuidNumber=" + zichanBaofeiUuidNumber +
            ", zichanBaofeiTypes=" + zichanBaofeiTypes +
            ", zichanBaofeiKucunNumber=" + zichanBaofeiKucunNumber +
            ", zichanBaofeiContent=" + zichanBaofeiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
