package com.entity.vo;

import com.entity.ZichanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zichan")
public class ZichanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资产编号
     */

    @TableField(value = "zichan_uuid_number")
    private String zichanUuidNumber;


    /**
     * 资产名称
     */

    @TableField(value = "zichan_name")
    private String zichanName;


    /**
     * 资产照片
     */

    @TableField(value = "zichan_photo")
    private String zichanPhoto;


    /**
     * 单位
     */

    @TableField(value = "zichan_danwei")
    private String zichanDanwei;


    /**
     * 资产类型
     */

    @TableField(value = "zichan_types")
    private Integer zichanTypes;


    /**
     * 资产数量
     */

    @TableField(value = "zichan_kucun_number")
    private Integer zichanKucunNumber;


    /**
     * 阈值
     */

    @TableField(value = "zichan_yuzhi")
    private Integer zichanYuzhi;


    /**
     * 资产介绍
     */

    @TableField(value = "zichan_content")
    private String zichanContent;


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
	 * 设置：资产编号
	 */
    public String getZichanUuidNumber() {
        return zichanUuidNumber;
    }


    /**
	 * 获取：资产编号
	 */

    public void setZichanUuidNumber(String zichanUuidNumber) {
        this.zichanUuidNumber = zichanUuidNumber;
    }
    /**
	 * 设置：资产名称
	 */
    public String getZichanName() {
        return zichanName;
    }


    /**
	 * 获取：资产名称
	 */

    public void setZichanName(String zichanName) {
        this.zichanName = zichanName;
    }
    /**
	 * 设置：资产照片
	 */
    public String getZichanPhoto() {
        return zichanPhoto;
    }


    /**
	 * 获取：资产照片
	 */

    public void setZichanPhoto(String zichanPhoto) {
        this.zichanPhoto = zichanPhoto;
    }
    /**
	 * 设置：单位
	 */
    public String getZichanDanwei() {
        return zichanDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setZichanDanwei(String zichanDanwei) {
        this.zichanDanwei = zichanDanwei;
    }
    /**
	 * 设置：资产类型
	 */
    public Integer getZichanTypes() {
        return zichanTypes;
    }


    /**
	 * 获取：资产类型
	 */

    public void setZichanTypes(Integer zichanTypes) {
        this.zichanTypes = zichanTypes;
    }
    /**
	 * 设置：资产数量
	 */
    public Integer getZichanKucunNumber() {
        return zichanKucunNumber;
    }


    /**
	 * 获取：资产数量
	 */

    public void setZichanKucunNumber(Integer zichanKucunNumber) {
        this.zichanKucunNumber = zichanKucunNumber;
    }
    /**
	 * 设置：阈值
	 */
    public Integer getZichanYuzhi() {
        return zichanYuzhi;
    }


    /**
	 * 获取：阈值
	 */

    public void setZichanYuzhi(Integer zichanYuzhi) {
        this.zichanYuzhi = zichanYuzhi;
    }
    /**
	 * 设置：资产介绍
	 */
    public String getZichanContent() {
        return zichanContent;
    }


    /**
	 * 获取：资产介绍
	 */

    public void setZichanContent(String zichanContent) {
        this.zichanContent = zichanContent;
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
