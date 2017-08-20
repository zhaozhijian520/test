package cn.itcast.springboot.service;

import java.util.List;
import java.util.Map;

import cn.itcast.springboot.domain.Notice;

public interface NoticeService {
	
	public List<Notice> finAll();

	public Map<String, Object> findByPage(Integer page, Integer rows);
}
