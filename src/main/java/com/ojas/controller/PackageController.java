package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.PackageEntity;
import com.ojas.service.PackageServiceImpl;

@RestController
public class PackageController {
	@Autowired
private  PackageServiceImpl packService;
	@PostMapping("/addpackage")
	public PackageEntity addPackage(@RequestBody PackageEntity pack) {
		
		return packService.saveOrUpdate(pack);	
	}
	
	@GetMapping("/allpack")
	private List<PackageEntity> getAllUser() {
		return packService.getAllPackages();

	}
}
