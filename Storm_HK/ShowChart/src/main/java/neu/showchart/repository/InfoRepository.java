package neu.showchart.repository;

import neu.showchart.entity.Info;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info,Integer> {

    List<Info> findAllByTimeBetween(String startDate, String endDate);
}
