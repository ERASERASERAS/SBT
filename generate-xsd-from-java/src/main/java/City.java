import javax.xml.bind.annotation.*;

/**
 * Created by usersbt on 10.07.2017.
 */
/**
 * Definition of a person with lastName and age, and optionally a firstName as well...
 *
 * @author usersbt
 * @custom A custom JavaDoc annotation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "City"
)
public class City {
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


    /**
        sas
     */
    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    /**
     * The XML namespace of this SomewhatNamedPerson.
     */
    private String name;
    @XmlAttribute
    private int population;
    private double square;



    public City(){

    }


}
