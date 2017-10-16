package com.example.demo.repository;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.File;

public interface FileRepository {
	public int insertFile(MultipartFile file, String name);
	public List<String> selectAll();
}
