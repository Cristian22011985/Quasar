package exam.cristian.quasar.controllers;

import exam.cristian.quasar.dto.PositionDto;
import exam.cristian.quasar.entity.Satellites;
import exam.cristian.quasar.dto.*;
import exam.cristian.quasar.response.PuntoMensaje;
import exam.cristian.quasar.services.TopSecret;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class TopSecretController {

    @Autowired
    private TopSecret topSecret ;

    @PostMapping
    @RequestMapping("/topsecret")
    public ResponseEntity<Object>createMessageLocation( @Valid @RequestBody SatellitesDto satellitesDTO) {

        String[] kenobi = new String[0];
        String[] skywalker = new String[0];
        String[] sato = new String[0];
        Float distanciaKenobi = 0f;
        Float distanciaSkywalker = 0f;
        Float distanciaSato = 0f;
        PositionDto positionDto = null ;
        String message = "";

        try {

            for (Satellites s : satellitesDTO.getSatellites()) {

                if (s.getName().equalsIgnoreCase("kenobi")) {
                    kenobi = s.getMessage();
                    distanciaKenobi = s.getDistance();
                } else if (s.getName().equalsIgnoreCase("skywalker")) {
                    skywalker = s.getMessage();
                    distanciaSkywalker = s.getDistance();
                } else if (s.getName().equalsIgnoreCase("sato")) {
                    sato = s.getMessage();
                    distanciaSato = s.getDistance();
                }
            }
            message = topSecret.getMessage(sato, kenobi, skywalker);
            positionDto = topSecret.getLocation(distanciaKenobi, distanciaSkywalker, distanciaSato);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (message.equals("") || positionDto == null){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            PuntoMensaje puntoMensaje = new PuntoMensaje(positionDto,message);

            return new ResponseEntity<>(puntoMensaje, HttpStatus.OK);
        }

    }
}
