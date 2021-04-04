package exam.cristian.quasar.services;

import exam.cristian.quasar.dto.PositionDto;

public interface TopSecret {

    String getMessage(String[] sato, String[] kenobi, String[] skywalker );

    PositionDto getLocation(float distanciaKenobi, float distanciaSkywalker, float distanciaSato);
}
