package exam.cristian.quasar.dto;

import java.util.List;
import exam.cristian.quasar.entity.Satellites;

public class SatellitesDto {
    private List<Satellites> satellites;

    public List<Satellites> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellites> satellites) {
        this.satellites = satellites;
    }


}
