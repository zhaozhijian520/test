package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.service.NoticeService;

@RestController
public class NoticeController {
	
	/** 注入业务层 */
	@Autowired
	private NoticeService noticeService;
	
	/** 查询所有的公告 */
	@GetMapping("/findAll")
	public List<Notice> findAll(){
		return noticeService.finAll();
	}
	
	/** 分页查询公告 */
	@RequestMapping("/findByPage")
	public Map<String, Object> findByPage(@RequestParam(value="page", defaultValue="1") Integer page,
			@RequestParam(value="rows",defaultValue="10" ) Integer rows){
		
		
		return noticeService.findByPage(page, rows);
	}
}
