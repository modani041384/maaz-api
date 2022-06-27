package com.maaz.api.repository;

import com.maaz.api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    /**
     * Find by companyId
     * @param companyId
     * @return
     */
    Company findByCompanyId(String companyId);

    //end
}
