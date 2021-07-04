package com.daysixhwtwo.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysixhwtwo.demo.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	Image findById(int userId);
}
