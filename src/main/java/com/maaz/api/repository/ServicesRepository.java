package com.maaz.api.repository;

import com.maaz.api.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    /**
     * Find by resourceId
     * @param serviceId
     * @return
     */
    Services findByServiceId(String serviceId);

    //end
}
