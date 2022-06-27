package com.maaz.api.repository;

import com.maaz.api.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    /**
     * Find Partner by partnerId
     * @param partnerId
     * @return
     */
    Partner findByPartnerId(String partnerId);

    //end
}
