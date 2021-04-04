package exam.cristian.quasar.services;

import exam.cristian.quasar.entity.Satellites;

import java.util.List;
import java.util.Optional;

public interface TopSecretSplit {

    void save(Satellites satellites);
    Optional<Satellites> getByName(String name);
    List<Satellites> findAll();
    Long count();
    boolean validarSatellite (String satelliteName);
    void deleteAll();
}

