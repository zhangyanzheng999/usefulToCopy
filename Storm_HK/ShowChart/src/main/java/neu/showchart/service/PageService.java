package neu.showchart.service;

import neu.showchart.entity.Info;
import org.springframework.data.domain.Page;

public interface PageService {
    Page<Info> findInfoNoCriteria(Integer page,Integer size);
}
