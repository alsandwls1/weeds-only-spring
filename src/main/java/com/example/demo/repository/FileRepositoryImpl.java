package com.example.demo.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileRepositoryImpl implements FileRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertFile(MultipartFile file, String name) {
		String sql = "insert into files (f_name, f_path) values(?, ?)";
		return jdbcTemplate.update(sql, name + file.getOriginalFilename(), "D:/uploads");
	}

	@Override
	public List<String> selectAll() {
		String sql = "select f_name from files";

		List<Map<String, Object>> list = new ArrayList<>();
		
		List<String> fileList = new ArrayList<>();
		list = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : list) {
			fileList.add((String) map.get("f_name"));
		}
		System.out.println("fileList = " + fileList);
		
		return fileList;
	}
}
