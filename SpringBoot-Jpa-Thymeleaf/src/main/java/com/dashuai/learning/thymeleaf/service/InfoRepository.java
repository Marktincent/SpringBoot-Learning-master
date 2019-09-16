package com.dashuai.learning.thymeleaf.service;

import com.dashuai.learning.thymeleaf.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Info repository.
 *
 * @author zhenghuan.wang
 */
public interface InfoRepository extends JpaRepository<Info, Long> {
    /**
     * Find by id info.
     *
     * @param id the id
     * @return the info
     */
    Info findById(long id);


}
