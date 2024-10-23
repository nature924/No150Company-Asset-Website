package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZichanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 资产
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zichan")
public class ZichanView extends ZichanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 资产类型的值
	*/
	@ColumnInfo(comment="资产类型的字典表值",type="varchar(200)")
	private String zichanValue;




	public ZichanView() {

	}

	public ZichanView(ZichanEntity zichanEntity) {
		try {
			BeanUtils.copyProperties(this, zichanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "ZichanView{" +
			", zichanValue=" + zichanValue +
			"} " + super.toString();
	}
}
