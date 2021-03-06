package exam.cristian.quasar.controllers;

import exam.cristian.quasar.dto.PositionDto;
import exam.cristian.quasar.entity.Satellites;
import exam.cristian.quasar.response.PuntoMensaje;
import exam.cristian.quasar.services.TopSecret;
import exam.cristian.quasar.services.TopSecretSplit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TopSecretSplitController {


    @Autowired
    private TopSecret topSecret;

    @Autowired
    private TopSecretSplit topSecretSplit;

    @PostMapping
    @RequestMapping("/topsecret_split/{satellite_name}")
    public ResponseEntity<Object> guardar(@PathVariable("satellite_name") String satelliteName, @RequestBody Satellites satellites) {

        if (!topSecretSplit.validarSatellite(satelliteName.toLowerCase() )){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        try {

            satellites.setName(satelliteName.toLowerCase() );
            topSecretSplit.save(satellites);


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/topsecret_split/delete")
    public ResponseEntity<Object> delete(){
        topSecretSplit.deleteAll();
        return new ResponseEntity<>("se eliminaron todos los registros", HttpStatus.OK);
    }


    @GetMapping
    @RequestMapping("/topsecret_split")
    public ResponseEntity<Object> getMessageLocation() {


           if (topSecretSplit.count() == 3)
           {

                      String[] kenobi = new String[0];
                      String[] skywalker = new String[0];
                      String[] sato = new String[0];
                      Float distanciaKenobi = 0f;
                      Float distanciaSkywalker = 0f;
                      Float distanciaSato = 0f;
                      PositionDto positionDto = null;
                      String message = "";

                      List<Satellites> listaSatellites ;
               try {
                       listaSatellites= topSecretSplit.findAll();

                       for (Satellites s : listaSatellites) {

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

           }else{

               return new ResponseEntity<>("No hay suficiente informacion",HttpStatus.NOT_FOUND);

           }


    }


}