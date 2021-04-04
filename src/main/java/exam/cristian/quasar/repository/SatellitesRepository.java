package exam.cristian.quasar.repository;

import exam.cristian.quasar.entity.Satellites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface SatellitesRepository extends JpaRepository<Satellites, String> {

    @Transactional(readOnly=true)
    Optional<Satellites> findByName(String name);
    @Transactional(readOnly=true)
    boolean existsByName(String name);

}
