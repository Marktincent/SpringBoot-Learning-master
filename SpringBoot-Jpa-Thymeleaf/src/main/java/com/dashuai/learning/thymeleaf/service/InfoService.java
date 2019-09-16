package com.dashuai.learning.thymeleaf.service;


import com.dashuai.learning.thymeleaf.model.Info;

import java.util.List;

/**
 * The interface Info service.
 *
 * @author Liaozihong
 */
public interface InfoService {

    List<Info> getInfoList();

    Info findInfoById(long id);

    void save(Info Info);

    void edit(Info Info);

    void delete(long id);
}
