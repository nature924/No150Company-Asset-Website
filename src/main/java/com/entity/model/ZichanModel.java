package com.entity.model;

import com.entity.ZichanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZichanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资产编号
     */
    private String zichanUuidNumber;


    /**
     * 资产名称
     */
    private String zichanName;


    /**
     * 资产照片
     */
    private String zichanPhoto;


    /**
     * 单位
     */
    private String zichanDanwei;


    /**
     * 资产类型
     */
    private Integer zichanTypes;


    /**
     * 资产数量
     */
    private Integer zichanKucunNumber;


    /**
     * 阈值
     */
    private Integer zichanYuzhi;


    /**
     * 资产介绍
     */
    private String zichanContent;


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
