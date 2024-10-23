
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
 * 资产申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zichanShenqing")
public class ZichanShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(ZichanShenqingController.class);

    private static final String TABLE_NAME = "zichanShenqing";

    @Autowired
    private ZichanShenqingService zichanShenqingService;


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
        PageUtils page = zichanShenqingService.queryPage(params);

        //字典表数据转换
        List<ZichanShenqingView> list =(List<ZichanShenqingView>)page.getList();
        for(ZichanShenqingView c:list){
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
        ZichanShenqingEntity zichanShenqing = zichanShenqingService.selectById(id);
        if(zichanShenqing !=null){
            //entity转view
            ZichanShenqingView view = new ZichanShenqingView();
            BeanUtils.copyProperties( zichanShenqing , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(zichanShenqing.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 资产
            //级联表
            ZichanEntity zichan = zichanService.selectById(zichanShenqing.getZichanId());
            if(zichan != null){
            BeanUtils.copyProperties( zichan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZichanId(zichan.getId());
            }
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
    public R save(@RequestBody ZichanShenqingEntity zichanShenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zichanShenqing:{}",this.getClass().getName(),zichanShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            zichanShenqing.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            zichanShenqing.setInsertTime(new Date());
            zichanShenqing.setZichanShenqingYesnoTypes(1);
            zichanShenqing.setCreateTime(new Date());
            zichanShenqingService.insert(zichanShenqing);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZichanShenqingEntity zichanShenqing, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zichanShenqing:{}",this.getClass().getName(),zichanShenqing.toString());
        ZichanShenqingEntity oldZichanShenqingEntity = zichanShenqingService.selectById(zichanShenqing.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            zichanShenqing.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(zichanShenqing.getZichanShenqingContent()) || "null".equals(zichanShenqing.getZichanShenqingContent())){
                zichanShenqing.setZichanShenqingContent(null);
        }
        if("".equals(zichanShenqing.getZichanShenqingYesnoText()) || "null".equals(zichanShenqing.getZichanShenqingYesnoText())){
                zichanShenqing.setZichanShenqingYesnoText(null);
        }

            zichanShenqingService.updateById(zichanShenqing);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ZichanShenqingEntity zichanShenqingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,zichanShenqingEntity:{}",this.getClass().getName(),zichanShenqingEntity.toString());

        ZichanShenqingEntity oldZichanShenqing = zichanShenqingService.selectById(zichanShenqingEntity.getId());//查询原先数据

        if(zichanShenqingEntity.getZichanShenqingYesnoTypes() == 2){//通过

            ZichanEntity zichanEntity = zichanService.selectById(oldZichanShenqing.getZichanId());
            int balance = zichanEntity.getZichanKucunNumber() - oldZichanShenqing.getZichanShenqingKucunNumber();
            if(balance<0)
                return R.error("申请数量大于库存数量,无法通过此申请");
            zichanEntity.setZichanKucunNumber(balance);
            zichanService.updateById(zichanEntity);
        }else if(zichanShenqingEntity.getZichanShenqingYesnoTypes() == 3){//拒绝
        }
        zichanShenqingEntity.setZichanShenqingShenheTime(new Date());//审核时间
        zichanShenqingService.updateById(zichanShenqingEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZichanShenqingEntity> oldZichanShenqingList =zichanShenqingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zichanShenqingService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZichanShenqingEntity> zichanShenqingList = new ArrayList<>();//上传的东西
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
                            ZichanShenqingEntity zichanShenqingEntity = new ZichanShenqingEntity();
//                            zichanShenqingEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            zichanShenqingEntity.setZichanId(Integer.valueOf(data.get(0)));   //资产 要改的
//                            zichanShenqingEntity.setZichanShenqingUuidNumber(data.get(0));                    //资产申请编号 要改的
//                            zichanShenqingEntity.setZichanShenqingTypes(Integer.valueOf(data.get(0)));   //资产申请类型 要改的
//                            zichanShenqingEntity.setZichanShenqingKucunNumber(Integer.valueOf(data.get(0)));   //资产申请数量 要改的
//                            zichanShenqingEntity.setZichanShenqingContent("");//详情和图片
//                            zichanShenqingEntity.setInsertTime(date);//时间
//                            zichanShenqingEntity.setZichanShenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            zichanShenqingEntity.setZichanShenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            zichanShenqingEntity.setZichanShenqingShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            zichanShenqingEntity.setCreateTime(date);//时间
                            zichanShenqingList.add(zichanShenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //资产申请编号
                                if(seachFields.containsKey("zichanShenqingUuidNumber")){
                                    List<String> zichanShenqingUuidNumber = seachFields.get("zichanShenqingUuidNumber");
                                    zichanShenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zichanShenqingUuidNumber = new ArrayList<>();
                                    zichanShenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zichanShenqingUuidNumber",zichanShenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //资产申请编号
                        List<ZichanShenqingEntity> zichanShenqingEntities_zichanShenqingUuidNumber = zichanShenqingService.selectList(new EntityWrapper<ZichanShenqingEntity>().in("zichan_shenqing_uuid_number", seachFields.get("zichanShenqingUuidNumber")));
                        if(zichanShenqingEntities_zichanShenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZichanShenqingEntity s:zichanShenqingEntities_zichanShenqingUuidNumber){
                                repeatFields.add(s.getZichanShenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [资产申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zichanShenqingService.insertBatch(zichanShenqingList);
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

