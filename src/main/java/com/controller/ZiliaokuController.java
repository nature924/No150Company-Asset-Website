
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
 * 资料库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ziliaoku")
public class ZiliaokuController {
    private static final Logger logger = LoggerFactory.getLogger(ZiliaokuController.class);

    private static final String TABLE_NAME = "ziliaoku";

    @Autowired
    private ZiliaokuService ziliaokuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private ZichanService zichanService;//资产
    @Autowired
    private ZichanBaofeiService zichanBaofeiService;//资产报废
    @Autowired
    private ZichanShenqingService zichanShenqingService;//资产申请
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
        PageUtils page = ziliaokuService.queryPage(params);

        //字典表数据转换
        List<ZiliaokuView> list =(List<ZiliaokuView>)page.getList();
        for(ZiliaokuView c:list){
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
        ZiliaokuEntity ziliaoku = ziliaokuService.selectById(id);
        if(ziliaoku !=null){
            //entity转view
            ZiliaokuView view = new ZiliaokuView();
            BeanUtils.copyProperties( ziliaoku , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZiliaokuEntity ziliaoku, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ziliaoku:{}",this.getClass().getName(),ziliaoku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZiliaokuEntity> queryWrapper = new EntityWrapper<ZiliaokuEntity>()
            .eq("ziliaoku_name", ziliaoku.getZiliaokuName())
            .eq("ziliaoku_types", ziliaoku.getZiliaokuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiliaokuEntity ziliaokuEntity = ziliaokuService.selectOne(queryWrapper);
        if(ziliaokuEntity==null){
            ziliaoku.setInsertTime(new Date());
            ziliaoku.setCreateTime(new Date());
            ziliaokuService.insert(ziliaoku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZiliaokuEntity ziliaoku, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,ziliaoku:{}",this.getClass().getName(),ziliaoku.toString());
        ZiliaokuEntity oldZiliaokuEntity = ziliaokuService.selectById(ziliaoku.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(ziliaoku.getZiliaokuFile()) || "null".equals(ziliaoku.getZiliaokuFile())){
                ziliaoku.setZiliaokuFile(null);
        }
        if("".equals(ziliaoku.getZiliaokuContent()) || "null".equals(ziliaoku.getZiliaokuContent())){
                ziliaoku.setZiliaokuContent(null);
        }

            ziliaokuService.updateById(ziliaoku);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZiliaokuEntity> oldZiliaokuList =ziliaokuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ziliaokuService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZiliaokuEntity> ziliaokuList = new ArrayList<>();//上传的东西
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
                            ZiliaokuEntity ziliaokuEntity = new ZiliaokuEntity();
//                            ziliaokuEntity.setZiliaokuUuidNumber(data.get(0));                    //资料编号 要改的
//                            ziliaokuEntity.setZiliaokuName(data.get(0));                    //资料名称 要改的
//                            ziliaokuEntity.setZiliaokuTypes(Integer.valueOf(data.get(0)));   //资料类型 要改的
//                            ziliaokuEntity.setZiliaokuFile(data.get(0));                    //资料文件 要改的
//                            ziliaokuEntity.setZiliaokuContent("");//详情和图片
//                            ziliaokuEntity.setInsertTime(date);//时间
//                            ziliaokuEntity.setCreateTime(date);//时间
                            ziliaokuList.add(ziliaokuEntity);


                            //把要查询是否重复的字段放入map中
                                //资料编号
                                if(seachFields.containsKey("ziliaokuUuidNumber")){
                                    List<String> ziliaokuUuidNumber = seachFields.get("ziliaokuUuidNumber");
                                    ziliaokuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> ziliaokuUuidNumber = new ArrayList<>();
                                    ziliaokuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("ziliaokuUuidNumber",ziliaokuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //资料编号
                        List<ZiliaokuEntity> ziliaokuEntities_ziliaokuUuidNumber = ziliaokuService.selectList(new EntityWrapper<ZiliaokuEntity>().in("ziliaoku_uuid_number", seachFields.get("ziliaokuUuidNumber")));
                        if(ziliaokuEntities_ziliaokuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZiliaokuEntity s:ziliaokuEntities_ziliaokuUuidNumber){
                                repeatFields.add(s.getZiliaokuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [资料编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        ziliaokuService.insertBatch(ziliaokuList);
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

