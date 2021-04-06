package exam.cristian.quasar.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="satellites")

@TypeDef(name = "string-array", typeClass = StringArrayType.class)
  /*      @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)*/

public class Satellites {

    @Id
    @Column(name="name",unique=true)
    private String name ;

    @Column(name="distance")
    @Min(value = 0, message ="{distance.min}" )
    private Float distance ;


    @Type(type = "string-array")
    @Column(columnDefinition = "text[]")
    private String [] message ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

}
