package com.entity.vo;

import com.entity.ZichanShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zichan_shenqing")
public class ZichanShenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 资产
     */

    @TableField(value = "zichan_id")
    private Integer zichanId;


    /**
     * 资产申请编号
     */

    @TableField(value = "zichan_shenqing_uuid_number")
    private String zichanShenqingUuidNumber;


    /**
     * 资产申请类型
     */

    @TableField(value = "zichan_shenqing_types")
    private Integer zichanShenqingTypes;


    /**
     * 资产申请数量
     */

    @TableField(value = "zichan_shenqing_kucun_number")
    private Integer zichanShenqingKucunNumber;


    /**
     * 申请缘由
     */

    @TableField(value = "zichan_shenqing_content")
    private String zichanShenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "zichan_shenqing_yesno_types")
    private Integer zichanShenqingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "zichan_shenqing_yesno_text")
    private String zichanShenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zichan_shenqing_shenhe_time")
    private Date zichanShenqingShenheTime;


    /**
     * 创建时间
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
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：资产
	 */
    public Integer getZichanId() {
        return zichanId;
    }


    /**
	 * 获取：资产
	 */

    public void setZichanId(Integer zichanId) {
        this.zichanId = zichanId;
    }
    /**
	 * 设置：资产申请编号
	 */
    public String getZichanShenqingUuidNumber() {
        return zichanShenqingUuidNumber;
    }


    /**
	 * 获取：资产申请编号
	 */

    public void setZichanShenqingUuidNumber(String zichanShenqingUuidNumber) {
        this.zichanShenqingUuidNumber = zichanShenqingUuidNumber;
    }
    /**
	 * 设置：资产申请类型
	 */
    public Integer getZichanShenqingTypes() {
        return zichanShenqingTypes;
    }


    /**
	 * 获取：资产申请类型
	 */

    public void setZichanShenqingTypes(Integer zichanShenqingTypes) {
        this.zichanShenqingTypes = zichanShenqingTypes;
    }
    /**
	 * 设置：资产申请数量
	 */
    public Integer getZichanShenqingKucunNumber() {
        return zichanShenqingKucunNumber;
    }


    /**
	 * 获取：资产申请数量
	 */

    public void setZichanShenqingKucunNumber(Integer zichanShenqingKucunNumber) {
        this.zichanShenqingKucunNumber = zichanShenqingKucunNumber;
    }
    /**
	 * 设置：申请缘由
	 */
    public String getZichanShenqingContent() {
        return zichanShenqingContent;
    }


    /**
	 * 获取：申请缘由
	 */

    public void setZichanShenqingContent(String zichanShenqingContent) {
        this.zichanShenqingContent = zichanShenqingContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getZichanShenqingYesnoTypes() {
        return zichanShenqingYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setZichanShenqingYesnoTypes(Integer zichanShenqingYesnoTypes) {
        this.zichanShenqingYesnoTypes = zichanShenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getZichanShenqingYesnoText() {
        return zichanShenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setZichanShenqingYesnoText(String zichanShenqingYesnoText) {
        this.zichanShenqingYesnoText = zichanShenqingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getZichanShenqingShenheTime() {
        return zichanShenqingShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setZichanShenqingShenheTime(Date zichanShenqingShenheTime) {
        this.zichanShenqingShenheTime = zichanShenqingShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
