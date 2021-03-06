package com.example.demo.controller;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.example.demo.repository.FileRepository;
import com.example.demo.service.StorageService;

@RestController
public class UploadController {

	@Autowired
	StorageService storageService;

	@Autowired
	FileRepository fileRepository2;

	List<String> files = new ArrayList<String>();

	@PostMapping("/post")
	// @PostMapping(value= {"/post"} ,consumes =
	// {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
//			storageService.store(file);
			files.add(file.getOriginalFilename());
			System.out.println(files);

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}


	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		System.out.println("1");
//		files.removeAll(files);

//		File directory = new File("D:/uploads");

		// File[] fs = directory.listFiles();
		//
		// for(File f:fs){
		// files.add(f.getName());
		// }
		// System.out.println(files);

//		files = fileRepository2.selectAll();

		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		System.out.println(fileNames);
		// fileNames = storageService.getfile();

		return ResponseEntity.ok().body(fileNames);

	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		// System.out.println("5");
		// System.out.println("getFile() # filename="+filename);
		// Resource file = storageService.loadFile(filename);
		// System.out.println("6");
		//
		// return ResponseEntity.ok()
		// .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
		// file.getFilename() + "\"")
		// .body(file);
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}