package cn.itcast.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.itcast.springboot.domain.Notice;

@Mapper
public interface NoticeMapper {
	
	/** 查询所有公告 */
	@Select("select * from notice")
	public List<Notice> findAll();

	public Long count();

	public List<Notice> findByPage(@Param(value="page") int page, @Param(value="rows") Integer rows);
	
}
