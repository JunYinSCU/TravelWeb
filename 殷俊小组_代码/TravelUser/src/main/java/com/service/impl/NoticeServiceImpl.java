package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.NoticeDao;
import com.entity.NoticeEntity;
import com.service.NoticeService;
import com.entity.vo.NoticeVO;
import com.entity.view.NoticeView;

@Service("newsService")
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NoticeEntity> page = this.selectPage(
                new Query<NoticeEntity>(params).getPage(),
                new EntityWrapper<NoticeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NoticeEntity> wrapper) {
		  Page<NoticeView> page =new Query<NoticeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NoticeVO> selectListVO(Wrapper<NoticeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NoticeVO selectVO(Wrapper<NoticeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NoticeView> selectListView(Wrapper<NoticeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NoticeView selectView(Wrapper<NoticeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
