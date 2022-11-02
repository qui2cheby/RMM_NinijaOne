package com.project.rmm_ninjaone.database;

import com.project.rmm_ninjaone.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

    @Modifying
    @Query("UPDATE Device d " +
            "SET d.system_name = :system_name " +
            "WHERE d.id = :id")
    @Transactional
    Integer updateDevice(@Param("id") Long id,
                    @Param("system_name") String system_name);

}
