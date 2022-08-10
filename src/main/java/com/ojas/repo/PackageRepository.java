package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.PackageEntity;
@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Integer>{

}
