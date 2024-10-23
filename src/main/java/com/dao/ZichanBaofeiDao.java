package com.dao;

import com.entity.ZichanBaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZichanBaofeiView;

/**
 * 资产报废 Dao 接口
 *
 * @author 
 */
public interface ZichanBaofeiDao extends BaseMapper<ZichanBaofeiEntity> {

   List<ZichanBaofeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
