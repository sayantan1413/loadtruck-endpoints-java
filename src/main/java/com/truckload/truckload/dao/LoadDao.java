package com.truckload.truckload.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.truckload.truckload.entities.Load;

public interface LoadDao extends JpaRepository<Load, Long> {

	 @Query("SELECT r FROM Load r WHERE r.shipperId=:n")
	  public List<Load> findElementByShipperId(@Param("n") long shipperId);
}	
