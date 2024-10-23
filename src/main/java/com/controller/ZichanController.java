
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 资产
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zichan")
public class ZichanController {
    private static final Logger logger = LoggerFactory.getLogger(ZichanController.class);

    private static final String TABLE_NAME = "zichan";

    @Autowired
    private ZichanService zichanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private ZichanBaofeiService zichanBaofeiService;//资产报废
    @Autowired
    private ZichanShenqingService zichanShenqingService;//资产申请
    @Autowired
    private ZiliaokuService ziliaokuService;//资料库
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = zichanService.queryPage(params);

        //字典表数据转换
        List<ZichanView> list =(List<ZichanView>)page.getList();
        for(ZichanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZichanEntity zichan = zichanService.selectById(id);
        if(zichan !=null){
            //entity转view
            ZichanView view = new ZichanView();
            BeanUtils.copyProperties( zichan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZichanEntity zichan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zichan:{}",this.getClass().getName(),zichan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZichanEntity> queryWrapper = new EntityWrapper<ZichanEntity>()
            .eq("zichan_name", zichan.getZichanName())
            .eq("zichan_danwei", zichan.getZichanDanwei())
            .eq("zichan_types", zichan.getZichanTypes())
            .eq("zichan_kucun_number", zichan.getZichanKucunNumber())
            .eq("zichan_yuzhi", zichan.getZichanYuzhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZichanEntity zichanEntity = zichanService.selectOne(queryWrapper);
        if(zichanEntity==null){
            zichan.setInsertTime(new Date());
            zichan.setCreateTime(new Date());
            zichanService.insert(zichan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZichanEntity zichan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zichan:{}",this.getClass().getName(),zichan.toString());
        ZichanEntity oldZichanEntity = zichanService.selectById(zichan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zichan.getZichanPhoto()) || "null".equals(zichan.getZichanPhoto())){
                zichan.setZichanPhoto(null);
        }
        if("".equals(zichan.getZichanContent()) || "null".equals(zichan.getZichanContent())){
                zichan.setZichanContent(null);
        }

            zichanService.updateById(zichan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZichanEntity> oldZichanList =zichanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zichanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yuangongId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZichanEntity> zichanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZichanEntity zichanEntity = new ZichanEntity();
//                            zichanEntity.setZichanUuidNumber(data.get(0));                    //资产编号 要改的
//                            zichanEntity.setZichanName(data.get(0));                    //资产名称 要改的
//                            zichanEntity.setZichanPhoto("");//详情和图片
//                            zichanEntity.setZichanDanwei(data.get(0));                    //单位 要改的
//                            zichanEntity.setZichanTypes(Integer.valueOf(data.get(0)));   //资产类型 要改的
//                            zichanEntity.setZichanKucunNumber(Integer.valueOf(data.get(0)));   //资产数量 要改的
//                            zichanEntity.setZichanYuzhi(Integer.valueOf(data.get(0)));   //阈值 要改的
//                            zichanEntity.setZichanContent("");//详情和图片
//                            zichanEntity.setInsertTime(date);//时间
//                            zichanEntity.setCreateTime(date);//时间
                            zichanList.add(zichanEntity);


                            //把要查询是否重复的字段放入map中
                                //资产编号
                                if(seachFields.containsKey("zichanUuidNumber")){
                                    List<String> zichanUuidNumber = seachFields.get("zichanUuidNumber");
                                    zichanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zichanUuidNumber = new ArrayList<>();
                                    zichanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zichanUuidNumber",zichanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //资产编号
                        List<ZichanEntity> zichanEntities_zichanUuidNumber = zichanService.selectList(new EntityWrapper<ZichanEntity>().in("zichan_uuid_number", seachFields.get("zichanUuidNumber")));
                        if(zichanEntities_zichanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZichanEntity s:zichanEntities_zichanUuidNumber){
                                repeatFields.add(s.getZichanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [资产编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zichanService.insertBatch(zichanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

