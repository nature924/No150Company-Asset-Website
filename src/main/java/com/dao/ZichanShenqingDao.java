package com.dao;

import com.entity.ZichanShenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZichanShenqingView;

/**
 * 资产申请 Dao 接口
 *
 * @author 
 */
public interface ZichanShenqingDao extends BaseMapper<ZichanShenqingEntity> {

   List<ZichanShenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
