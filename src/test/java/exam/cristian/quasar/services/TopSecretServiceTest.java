package exam.cristian.quasar.services;

import exam.cristian.quasar.services.impl.TopSecretImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class TopSecretServiceTest {

    @InjectMocks
    private TopSecretImpl topSecretimpl;

    @Test
    public void getMessageTest(){

        String esperado = "Mensaje de Prueba";
        String resultado ="";
        String [] sato = new String [] {"Mensaje","de",""} ;
        String [] skywalker = new String [] {"","","Prueba"} ;
        String [] kenobi = new String [] {"","",""} ;

         resultado = topSecretimpl.getMessage(sato,skywalker,kenobi);

         assertEquals(esperado,resultado);

    }

}
