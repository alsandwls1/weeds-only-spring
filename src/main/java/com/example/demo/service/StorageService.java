package com.example.demo.service;

//package com.javasampleapproach.uploadfiles.storage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.FileRepository;

@Service
public class StorageService {
	
	@Autowired
	FileRepository fileRepository;

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	long i = System.currentTimeMillis();

	//	private final Path rootLocation = Paths.get("upload-dir");
	private final Path rootLocation = Paths.get("D:/uploads");
	
	public void store(MultipartFile file) throws IOException {
		try {
			String name = String.valueOf(i); 
			System.out.println(name+file.getOriginalFilename());
			Files.copy(file.getInputStream(), this.rootLocation.resolve(name+file.getOriginalFilename()));
			fileRepository.insertFile(file, name);
		} catch (Exception e) {
			System.out.println("중복중복!!");
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			System.out.println("pathfile = "+file);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}