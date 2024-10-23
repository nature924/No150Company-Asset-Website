package com.entity.model;

import com.entity.ZiliaokuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资料库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZiliaokuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资料编号
     */
    private String ziliaokuUuidNumber;


    /**
     * 资料名称
     */
    private String ziliaokuName;


    /**
     * 资料类型
     */
    private Integer ziliaokuTypes;


    /**
     * 资料文件
     */
    private String ziliaokuFile;


    /**
     * 资料介绍
     */
    private String ziliaokuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
