package com.entity.model;

import com.entity.ZichanBaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产报废
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZichanBaofeiModel implements Serializable {
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
     * 资产报废编号
     */
    private String zichanBaofeiUuidNumber;


    /**
     * 资产报废类型
     */
    private Integer zichanBaofeiTypes;


    /**
     * 资产报废数量
     */
    private Integer zichanBaofeiKucunNumber;


    /**
     * 报废缘由
     */
    private String zichanBaofeiContent;


    /**
     * 报废时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
