package com.maaz.api.repository;

import com.maaz.api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    /**
     * Find by resourceId
     * @param newsId
     * @return
     */
    News findByNewsId(String newsId);

    //end
}
