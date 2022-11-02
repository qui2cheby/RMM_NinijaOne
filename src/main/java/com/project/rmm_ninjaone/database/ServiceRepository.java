package com.project.rmm_ninjaone.database;

import com.project.rmm_ninjaone.model.ServiceDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceDTO, Long> {
}
