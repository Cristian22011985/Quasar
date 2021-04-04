package exam.cristian.quasar.response;

import exam.cristian.quasar.dto.PositionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuntoMensaje {

   private PositionDto position;
   private String message;

    public PuntoMensaje(PositionDto position, String message){
        this.position = position;
        this.message= message;

    }
}
