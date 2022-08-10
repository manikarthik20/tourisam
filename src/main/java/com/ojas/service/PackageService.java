package com.ojas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.entity.PackageEntity;

@Service
public interface PackageService {
	public PackageEntity saveOrUpdate(PackageEntity pack);
	public List<PackageEntity> getAllPackages();
}
