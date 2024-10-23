package com.entity.vo;

import com.entity.ZiliaokuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资料库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ziliaoku")
public class ZiliaokuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资料编号
     */

    @TableField(value = "ziliaoku_uuid_number")
    private String ziliaokuUuidNumber;


    /**
     * 资料名称
     */

    @TableField(value = "ziliaoku_name")
    private String ziliaokuName;


    /**
     * 资料类型
     */

    @TableField(value = "ziliaoku_types")
    private Integer ziliaokuTypes;


    /**
     * 资料文件
     */

    @TableField(value = "ziliaoku_file")
    private String ziliaokuFile;


    /**
     * 资料介绍
     */

    @TableField(value = "ziliaoku_content")
    private String ziliaokuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：资料编号
	 */
    public String getZiliaokuUuidNumber() {
        return ziliaokuUuidNumber;
    }


    /**
	 * 获取：资料编号
	 */

    public void setZiliaokuUuidNumber(String ziliaokuUuidNumber) {
        this.ziliaokuUuidNumber = ziliaokuUuidNumber;
    }
    /**
	 * 设置：资料名称
	 */
    public String getZiliaokuName() {
        return ziliaokuName;
    }


    /**
	 * 获取：资料名称
	 */

    public void setZiliaokuName(String ziliaokuName) {
        this.ziliaokuName = ziliaokuName;
    }
    /**
	 * 设置：资料类型
	 */
    public Integer getZiliaokuTypes() {
        return ziliaokuTypes;
    }


    /**
	 * 获取：资料类型
	 */

    public void setZiliaokuTypes(Integer ziliaokuTypes) {
        this.ziliaokuTypes = ziliaokuTypes;
    }
    /**
	 * 设置：资料文件
	 */
    public String getZiliaokuFile() {
        return ziliaokuFile;
    }


    /**
	 * 获取：资料文件
	 */

    public void setZiliaokuFile(String ziliaokuFile) {
        this.ziliaokuFile = ziliaokuFile;
    }
    /**
	 * 设置：资料介绍
	 */
    public String getZiliaokuContent() {
        return ziliaokuContent;
    }


    /**
	 * 获取：资料介绍
	 */

    public void setZiliaokuContent(String ziliaokuContent) {
        this.ziliaokuContent = ziliaokuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
