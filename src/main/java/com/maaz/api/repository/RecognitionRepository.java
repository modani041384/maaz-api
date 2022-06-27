package com.maaz.api.repository;

import com.maaz.api.entity.Recognitions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecognitionRepository extends JpaRepository<Recognitions, Long> {
    /**
     * Find Recognitions by Recognitions
     * @param recognitionsId
     * @return
     */
    Recognitions findByRecognitionsId(String recognitionsId);

    //end
}
