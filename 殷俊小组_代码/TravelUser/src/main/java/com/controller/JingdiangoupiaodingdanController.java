package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JingdiangoupiaodingdanEntity;
import com.entity.view.JingdiangoupiaodingdanView;

import com.service.JingdiangoupiaodingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 景点购票订单
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-30 11:47:11
 */
@RestController
@RequestMapping("/jingdiangoupiaodingdan")
public class JingdiangoupiaodingdanController {
    @Autowired
    private JingdiangoupiaodingdanService jingdiangoupiaodingdanService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdiangoupiaodingdanEntity jingdiangoupiaodingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("youke")) {
			jingdiangoupiaodingdan.setYoukezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingdiangoupiaodingdanEntity> ew = new EntityWrapper<JingdiangoupiaodingdanEntity>();
		PageUtils page = jingdiangoupiaodingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdiangoupiaodingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdiangoupiaodingdanEntity jingdiangoupiaodingdan, 
		HttpServletRequest request){
        EntityWrapper<JingdiangoupiaodingdanEntity> ew = new EntityWrapper<JingdiangoupiaodingdanEntity>();
		PageUtils page = jingdiangoupiaodingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdiangoupiaodingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdiangoupiaodingdanEntity jingdiangoupiaodingdan){
       	EntityWrapper<JingdiangoupiaodingdanEntity> ew = new EntityWrapper<JingdiangoupiaodingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdiangoupiaodingdan, "jingdiangoupiaodingdan")); 
        return R.ok().put("data", jingdiangoupiaodingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdiangoupiaodingdanEntity jingdiangoupiaodingdan){
        EntityWrapper< JingdiangoupiaodingdanEntity> ew = new EntityWrapper< JingdiangoupiaodingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdiangoupiaodingdan, "jingdiangoupiaodingdan")); 
		JingdiangoupiaodingdanView jingdiangoupiaodingdanView =  jingdiangoupiaodingdanService.selectView(ew);
		return R.ok("查询景点购票订单成功").put("data", jingdiangoupiaodingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdiangoupiaodingdanEntity jingdiangoupiaodingdan = jingdiangoupiaodingdanService.selectById(id);
        return R.ok().put("data", jingdiangoupiaodingdan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdiangoupiaodingdanEntity jingdiangoupiaodingdan = jingdiangoupiaodingdanService.selectById(id);
        return R.ok().put("data", jingdiangoupiaodingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingdiangoupiaodingdanEntity jingdiangoupiaodingdan, HttpServletRequest request){
    	jingdiangoupiaodingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdiangoupiaodingdan);
        jingdiangoupiaodingdanService.insert(jingdiangoupiaodingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingdiangoupiaodingdanEntity jingdiangoupiaodingdan, HttpServletRequest request){
    	jingdiangoupiaodingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdiangoupiaodingdan);
        jingdiangoupiaodingdanService.insert(jingdiangoupiaodingdan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JingdiangoupiaodingdanEntity jingdiangoupiaodingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdiangoupiaodingdan);
        jingdiangoupiaodingdanService.updateById(jingdiangoupiaodingdan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingdiangoupiaodingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JingdiangoupiaodingdanEntity> wrapper = new EntityWrapper<JingdiangoupiaodingdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("youke")) {
			wrapper.eq("youkezhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jingdiangoupiaodingdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

    @RequestMapping("/orderList")
    public R orderList(HttpServletRequest request) {
        // 获取当前用户
        String youkezhanghao = (String) request.getSession().getAttribute("username");
        System.out.println("youkezhanghao: " + youkezhanghao);
        // 创建查询条件
        EntityWrapper<JingdiangoupiaodingdanEntity> ew = new EntityWrapper<>();
        ew.eq("youkezhanghao", youkezhanghao);

        // 查询所有订单
        List<JingdiangoupiaodingdanEntity> allOrders = jingdiangoupiaodingdanService.selectList(ew);

        // 分类订单
        List<JingdiangoupiaodingdanEntity> currentOrders = new ArrayList<>();
        List<JingdiangoupiaodingdanEntity> historyOrders = new ArrayList<>();

        Date currentDate = new Date();

        for (JingdiangoupiaodingdanEntity order : allOrders) {
            // 假设订单的购票时间在当前时间之后为当前订单
            if (order.getGoupiaoshijian().after(currentDate)) {
                currentOrders.add(order);
            } else {
                historyOrders.add(order);
            }
        }

        // 创建返回的 Map
        Map<String, Object> result = new HashMap<>();
        result.put("currentOrders", currentOrders);
        result.put("historyOrders", historyOrders);

        return R.ok().put("data", result);
    }

    @RequestMapping("/about")
    public R about() {
        Map<String, String> result = new HashMap<>();
        String brief = jingdiangoupiaodingdanService.getBrief();
        result.put("about",brief);
        return R.ok().put("data", result);
    }

	


}
