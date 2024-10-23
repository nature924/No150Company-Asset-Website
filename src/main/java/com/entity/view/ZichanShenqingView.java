package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZichanShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 资产申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zichan_shenqing")
public class ZichanShenqingView extends ZichanShenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 资产申请类型的值
	*/
	@ColumnInfo(comment="资产申请类型的字典表值",type="varchar(200)")
	private String zichanShenqingValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String zichanShenqingYesnoValue;

	//级联表 员工
		/**
		* 工号
		*/

		@ColumnInfo(comment="工号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 部门
		*/
		@ColumnInfo(comment="部门",type="int(11)")
		private Integer bumenTypes;
			/**
			* 部门的值
			*/
			@ColumnInfo(comment="部门的字典表值",type="varchar(200)")
			private String bumenValue;
		/**
		* 职位
		*/
		@ColumnInfo(comment="职位",type="int(11)")
		private Integer zhiweiTypes;
			/**
			* 职位的值
			*/
			@ColumnInfo(comment="职位的字典表值",type="varchar(200)")
			private String zhiweiValue;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;
	//级联表 资产
		/**
		* 资产编号
		*/

		@ColumnInfo(comment="资产编号",type="varchar(200)")
		private String zichanUuidNumber;
		/**
		* 资产名称
		*/

		@ColumnInfo(comment="资产名称",type="varchar(200)")
		private String zichanName;
		/**
		* 资产照片
		*/

		@ColumnInfo(comment="资产照片",type="varchar(200)")
		private String zichanPhoto;
		/**
		* 单位
		*/

		@ColumnInfo(comment="单位",type="varchar(200)")
		private String zichanDanwei;
		/**
		* 资产类型
		*/
		@ColumnInfo(comment="资产类型",type="int(11)")
		private Integer zichanTypes;
			/**
			* 资产类型的值
			*/
			@ColumnInfo(comment="资产类型的字典表值",type="varchar(200)")
			private String zichanValue;
		/**
		* 资产数量
		*/

		@ColumnInfo(comment="资产数量",type="int(11)")
		private Integer zichanKucunNumber;
		/**
		* 阈值
		*/

		@ColumnInfo(comment="阈值",type="int(11)")
		private Integer zichanYuzhi;
		/**
		* 资产介绍
		*/

		@ColumnInfo(comment="资产介绍",type="longtext")
		private String zichanContent;



	public ZichanShenqingView() {

	}

	public ZichanShenqingView(ZichanShenqingEntity zichanShenqingEntity) {
		try {
			BeanUtils.copyProperties(this, zichanShenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 资产申请类型的值
	*/
	public String getZichanShenqingValue() {
		return zichanShenqingValue;
	}
	/**
	* 设置： 资产申请类型的值
	*/
	public void setZichanShenqingValue(String zichanShenqingValue) {
		this.zichanShenqingValue = zichanShenqingValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getZichanShenqingYesnoValue() {
		return zichanShenqingYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setZichanShenqingYesnoValue(String zichanShenqingYesnoValue) {
		this.zichanShenqingYesnoValue = zichanShenqingYesnoValue;
	}


	//级联表的get和set 员工

		/**
		* 获取： 工号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 工号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}
		/**
		* 获取： 部门
		*/
		public Integer getBumenTypes() {
			return bumenTypes;
		}
		/**
		* 设置： 部门
		*/
		public void setBumenTypes(Integer bumenTypes) {
			this.bumenTypes = bumenTypes;
		}


			/**
			* 获取： 部门的值
			*/
			public String getBumenValue() {
				return bumenValue;
			}
			/**
			* 设置： 部门的值
			*/
			public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
			}
		/**
		* 获取： 职位
		*/
		public Integer getZhiweiTypes() {
			return zhiweiTypes;
		}
		/**
		* 设置： 职位
		*/
		public void setZhiweiTypes(Integer zhiweiTypes) {
			this.zhiweiTypes = zhiweiTypes;
		}


			/**
			* 获取： 职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}
	//级联表的get和set 资产

		/**
		* 获取： 资产编号
		*/
		public String getZichanUuidNumber() {
			return zichanUuidNumber;
		}
		/**
		* 设置： 资产编号
		*/
		public void setZichanUuidNumber(String zichanUuidNumber) {
			this.zichanUuidNumber = zichanUuidNumber;
		}

		/**
		* 获取： 资产名称
		*/
		public String getZichanName() {
			return zichanName;
		}
		/**
		* 设置： 资产名称
		*/
		public void setZichanName(String zichanName) {
			this.zichanName = zichanName;
		}

		/**
		* 获取： 资产照片
		*/
		public String getZichanPhoto() {
			return zichanPhoto;
		}
		/**
		* 设置： 资产照片
		*/
		public void setZichanPhoto(String zichanPhoto) {
			this.zichanPhoto = zichanPhoto;
		}

		/**
		* 获取： 单位
		*/
		public String getZichanDanwei() {
			return zichanDanwei;
		}
		/**
		* 设置： 单位
		*/
		public void setZichanDanwei(String zichanDanwei) {
			this.zichanDanwei = zichanDanwei;
		}
		/**
		* 获取： 资产类型
		*/
		public Integer getZichanTypes() {
			return zichanTypes;
		}
		/**
		* 设置： 资产类型
		*/
		public void setZichanTypes(Integer zichanTypes) {
			this.zichanTypes = zichanTypes;
		}


			/**
			* 获取： 资产类型的值
			*/
			public String getZichanValue() {
				return zichanValue;
			}
			/**
			* 设置： 资产类型的值
			*/
			public void setZichanValue(String zichanValue) {
				this.zichanValue = zichanValue;
			}

		/**
		* 获取： 资产数量
		*/
		public Integer getZichanKucunNumber() {
			return zichanKucunNumber;
		}
		/**
		* 设置： 资产数量
		*/
		public void setZichanKucunNumber(Integer zichanKucunNumber) {
			this.zichanKucunNumber = zichanKucunNumber;
		}

		/**
		* 获取： 阈值
		*/
		public Integer getZichanYuzhi() {
			return zichanYuzhi;
		}
		/**
		* 设置： 阈值
		*/
		public void setZichanYuzhi(Integer zichanYuzhi) {
			this.zichanYuzhi = zichanYuzhi;
		}

		/**
		* 获取： 资产介绍
		*/
		public String getZichanContent() {
			return zichanContent;
		}
		/**
		* 设置： 资产介绍
		*/
		public void setZichanContent(String zichanContent) {
			this.zichanContent = zichanContent;
		}


	@Override
	public String toString() {
		return "ZichanShenqingView{" +
			", zichanShenqingValue=" + zichanShenqingValue +
			", zichanShenqingYesnoValue=" + zichanShenqingYesnoValue +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			", zichanUuidNumber=" + zichanUuidNumber +
			", zichanName=" + zichanName +
			", zichanPhoto=" + zichanPhoto +
			", zichanDanwei=" + zichanDanwei +
			", zichanKucunNumber=" + zichanKucunNumber +
			", zichanYuzhi=" + zichanYuzhi +
			", zichanContent=" + zichanContent +
			"} " + super.toString();
	}
}
