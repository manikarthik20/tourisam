package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
