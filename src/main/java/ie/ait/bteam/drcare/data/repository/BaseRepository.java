package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends Base, Long> extends JpaRepository<T, Long> {
//    T findOne(Long id);
//    List<T> findAll();
//    Page<T> findAll(Pageable pageable);
}
