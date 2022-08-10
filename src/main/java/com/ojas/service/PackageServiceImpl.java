package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.PackageEntity;
import com.ojas.repo.PackageRepository;
@Service
public class PackageServiceImpl implements PackageService{

	@Autowired
	private PackageRepository packRepo;
	@Override
	public PackageEntity saveOrUpdate(PackageEntity pack) {
	
		return packRepo.save(pack);
	}
	@Override
	public List<PackageEntity> getAllPackages() {
		
		return packRepo.findAll();
	}

}
