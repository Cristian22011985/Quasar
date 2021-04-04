package exam.cristian.quasar.response;

import exam.cristian.quasar.dto.PositionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuntoMensaje {

   private PositionDto positionDto;
   private String message;

    public PuntoMensaje(PositionDto positionDto, String message){
        this.positionDto = positionDto;
        this.message= message;

    }
}
