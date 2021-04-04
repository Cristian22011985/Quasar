package exam.cristian.quasar.services.impl;

import exam.cristian.quasar.entity.Satellites;
import exam.cristian.quasar.repository.SatellitesRepository;
import exam.cristian.quasar.services.TopSecretSplit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopSecretSplitImpl implements TopSecretSplit {

    @Autowired
    SatellitesRepository satellitesRepository;

    @Override
    public Optional<Satellites> getByName(String name) {
        return satellitesRepository.findByName(name); }
    @Override
    public List<Satellites> findAll() {
      return  satellitesRepository.findAll();
    }

    @Override
    public Long count() {
      return satellitesRepository.count();
    }

    @Override
    public void deleteAll() {
        satellitesRepository.deleteAll();
    }

    @Override
    public boolean validarSatellite(String satelliteName) {
        boolean valido = false ;
        if (satelliteName.equalsIgnoreCase("sato" )){
            valido = true ;
        }else if( satelliteName.equalsIgnoreCase("skywalker" )  )
        {
            valido = true ;
        }else if (satelliteName.equalsIgnoreCase("kenobi" ) )
        {
            valido = true ;
        }
        return  valido ;
    }

    @Override
    public void save(Satellites satellites) {
        satellitesRepository.save(satellites);
    }
}