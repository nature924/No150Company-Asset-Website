package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZiliaokuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 资料库
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("ziliaoku")
public class ZiliaokuView extends ZiliaokuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 资料类型的值
	*/
	@ColumnInfo(comment="资料类型的字典表值",type="varchar(200)")
	private String ziliaokuValue;




	public ZiliaokuView() {

	}

	public ZiliaokuView(ZiliaokuEntity ziliaokuEntity) {
		try {
			BeanUtils.copyProperties(this, ziliaokuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 资料类型的值
	*/
	public String getZiliaokuValue() {
		return ziliaokuValue;
	}
	/**
	* 设置： 资料类型的值
	*/
	public void setZiliaokuValue(String ziliaokuValue) {
		this.ziliaokuValue = ziliaokuValue;
	}




	@Override
	public String toString() {
		return "ZiliaokuView{" +
			", ziliaokuValue=" + ziliaokuValue +
			"} " + super.toString();
	}
}
