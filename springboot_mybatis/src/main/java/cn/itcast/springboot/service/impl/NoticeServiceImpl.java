package cn.itcast.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.mapper.NoticeMapper;
import cn.itcast.springboot.service.NoticeService;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	
	/** 注入数据访问接口 */
	@Autowired
	private NoticeMapper noticeMapper;
	@Override
	public List<Notice> finAll() {
		return noticeMapper.findAll();
	}
	@Override
	public Map<String, Object> findByPage(Integer page, Integer rows) {
		Long total= noticeMapper.count();
		List<Notice> notices= noticeMapper.findByPage((page - 1) * rows, rows);
		HashMap<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", notices);
		return map;
	}

}
