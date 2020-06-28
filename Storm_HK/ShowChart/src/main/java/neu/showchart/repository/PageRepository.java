package neu.showchart.repository;

import neu.showchart.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PageRepository  extends JpaRepository<Info,Integer>, JpaSpecificationExecutor<Info> {




}
