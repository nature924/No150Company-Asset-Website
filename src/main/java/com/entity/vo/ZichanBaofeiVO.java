package com.entity.vo;

import com.entity.ZichanBaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产报废
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zichan_baofei")
public class ZichanBaofeiVO implements Serializable {
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
     * 资产报废编号
     */

    @TableField(value = "zichan_baofei_uuid_number")
    private String zichanBaofeiUuidNumber;


    /**
     * 资产报废类型
     */

    @TableField(value = "zichan_baofei_types")
    private Integer zichanBaofeiTypes;


    /**
     * 资产报废数量
     */

    @TableField(value = "zichan_baofei_kucun_number")
    private Integer zichanBaofeiKucunNumber;


    /**
     * 报废缘由
     */

    @TableField(value = "zichan_baofei_content")
    private String zichanBaofeiContent;


    /**
     * 报废时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：资产报废编号
	 */
    public String getZichanBaofeiUuidNumber() {
        return zichanBaofeiUuidNumber;
    }


    /**
	 * 获取：资产报废编号
	 */

    public void setZichanBaofeiUuidNumber(String zichanBaofeiUuidNumber) {
        this.zichanBaofeiUuidNumber = zichanBaofeiUuidNumber;
    }
    /**
	 * 设置：资产报废类型
	 */
    public Integer getZichanBaofeiTypes() {
        return zichanBaofeiTypes;
    }


    /**
	 * 获取：资产报废类型
	 */

    public void setZichanBaofeiTypes(Integer zichanBaofeiTypes) {
        this.zichanBaofeiTypes = zichanBaofeiTypes;
    }
    /**
	 * 设置：资产报废数量
	 */
    public Integer getZichanBaofeiKucunNumber() {
        return zichanBaofeiKucunNumber;
    }


    /**
	 * 获取：资产报废数量
	 */

    public void setZichanBaofeiKucunNumber(Integer zichanBaofeiKucunNumber) {
        this.zichanBaofeiKucunNumber = zichanBaofeiKucunNumber;
    }
    /**
	 * 设置：报废缘由
	 */
    public String getZichanBaofeiContent() {
        return zichanBaofeiContent;
    }


    /**
	 * 获取：报废缘由
	 */

    public void setZichanBaofeiContent(String zichanBaofeiContent) {
        this.zichanBaofeiContent = zichanBaofeiContent;
    }
    /**
	 * 设置：报废时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报废时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
