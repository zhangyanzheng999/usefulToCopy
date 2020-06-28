package neu.showchart.service.Impl;

import neu.showchart.repository.SocketRepository;
import neu.showchart.service.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 为了定时任务
 */
@Service("SocketService")
public class SocketServiceImpl implements SocketService {
    @Autowired
    SocketRepository socketRepository;
    @Override
    public int getAllInfoSize() {
        return socketRepository.findAll().size();
    }
}
