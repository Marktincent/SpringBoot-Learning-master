package com.dashuai.learning.thymeleaf.service.impl;

import com.dashuai.learning.thymeleaf.model.Info;
import com.dashuai.learning.thymeleaf.service.InfoRepository;
import com.dashuai.learning.thymeleaf.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Info repository
 * <p/>
 * Created in 2019.06.08
 * <p/>
 *
 * @author <a href="" style="background: #55a7e3;">zhenghuan.wang</a>
 */
@Service
public class InfoRepositoryImpl implements InfoService {
    @Autowired
    private InfoRepository infoRepository;

    @Override
    public List<Info> getInfoList() {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return infoRepository.findAll(sort);
    }

    @Override
    public Info findInfoById(long id) {
        return infoRepository.findById(id);
    }

    @Override
    public void save(Info Info) {
        infoRepository.save(Info);
    }

    @Override
    public void edit(Info Info) {
        infoRepository.save(Info);
    }

    @Override
    public void delete(long id) {
        infoRepository.deleteById(id);
    }
}
