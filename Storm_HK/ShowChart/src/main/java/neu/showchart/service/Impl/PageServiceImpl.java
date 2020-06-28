package neu.showchart.service.Impl;

import neu.showchart.entity.Info;
import neu.showchart.repository.PageRepository;
import neu.showchart.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 实现分页
 */
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageRepository pageRepository;

    @Override
    public Page<Info> findInfoNoCriteria(Integer page, Integer size) {
        return pageRepository.findAll(PageRequest.of(page,size, Sort.Direction.DESC, "id"));
    }
}
