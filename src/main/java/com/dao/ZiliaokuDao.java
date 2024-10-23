package com.dao;

import com.entity.ZiliaokuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiliaokuView;

/**
 * 资料库 Dao 接口
 *
 * @author 
 */
public interface ZiliaokuDao extends BaseMapper<ZiliaokuEntity> {

   List<ZiliaokuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
