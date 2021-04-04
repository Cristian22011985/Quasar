package exam.cristian.quasar.services.impl;

import exam.cristian.quasar.dto.PositionDto;
import exam.cristian.quasar.services.TopSecret;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TopSecretImpl implements TopSecret {


    @Override
    public String getMessage(String[] sato, String[] kenobi, String[] skywalker) {
        int largoMensaje =  Math.min(Math.min(sato.length, kenobi.length), skywalker.length);
        int largoSato = sato.length-1;
        int largoKenobi= kenobi.length-1;
        int largoskywalker = skywalker.length-1;
        String respuesta = "";

        List<String> mensaje = new ArrayList<>();

        for(int i = 0;i < largoMensaje;i++ ){

            if (!sato[largoSato-i].equals("") || !kenobi[largoKenobi-i].equals("") || !skywalker[largoskywalker-i].equals("")  ) {

                mensaje.add(0, (!sato[largoSato - i].equals("") ? sato[largoSato - i] : (!kenobi[largoKenobi - i].equals("") ? kenobi[largoKenobi - i] : skywalker[largoskywalker - i])));

            }else break;
        }
        String delim = " ";

        respuesta = String.join(delim, mensaje);

        return respuesta;

}


    @Override
    public PositionDto getLocation(float distanciaKenobi, float distanciaSkywalker, float distanciaSato) {

        PositionDto kenobi = new PositionDto(-500,-200);    //1
        PositionDto skywalker = new PositionDto(100,-100);  //2
        PositionDto sato = new PositionDto(500,100);     //3

        float puntox ;
        float puntoy ;

        float dKenobi = distanciaKenobi;
        float dsakywalker = distanciaSkywalker;
        float dSato=distanciaSato;

        float A,B,C,D,E,F ;

        A = 2 * skywalker.getX() - 2 * kenobi.getX();
        B = 2 * skywalker.getY() - 2 * kenobi.getY();
        C =   exponential(dKenobi, 2) - exponential(dsakywalker,2) - exponential(kenobi.getX(),2) + exponential(skywalker.getX(),2) - exponential(kenobi.getY(),2) + exponential(skywalker.getY(),2);
        D = 2*sato.getX() - 2*skywalker.getX();
        E = 2*sato.getY() - 2*skywalker.getY();
        F = exponential(dsakywalker,2) - exponential(dSato,2) - exponential(skywalker.getX(),2) + exponential(sato.getX(),2) - exponential(skywalker.getY(),2) + exponential(sato.getY(),2);
        puntox = (C*E - F*B) / (E*A - B*D) ;
        puntoy = (C*D - A*F) / (B*D - A*E) ;

        return new PositionDto(puntox,puntoy);
    }

    public float exponential(float a,float b ){
        return (float)Math.pow(a,b); }



}
