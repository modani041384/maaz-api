package com.maaz.api.repository;

import com.maaz.api.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    /**
     * Find by productId
     * @param productId
     * @return
     */
    Products findByProductId(String productId);

    //end
}
