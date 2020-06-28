package neu.showchart.repository;

import neu.showchart.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocketRepository extends JpaRepository<Info,Integer> {

}
