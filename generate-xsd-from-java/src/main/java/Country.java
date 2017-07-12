import javax.xml.bind.annotation.*;
import java.util.List;



/**
 * Created by usersbt on 10.07.2017.
 */
//@XmlType(namespace = "http://memorynotfound.com/course")
//@XmlSeeAlso({City.class})
@XmlRootElement
public class Country {

    private List<City> cities;

    public Country() {
    }

    public List<City> getCities() {
        return cities;
    }
    @XmlElement(name ="city")
    @XmlElementWrapper
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
