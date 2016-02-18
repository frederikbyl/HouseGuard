package com.houseguard.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.houseguard.model.ProbeRequest;

/**
 * 
 * @author The Rebels
 *
 */
public interface ProbeRequestRepository extends JpaRepository<ProbeRequest, Integer> {

	@Query("SELECT c FROM ProbeRequest c WHERE c.id = :id")
	public ProbeRequest findOne(@Param("id") Integer id);
	
}
