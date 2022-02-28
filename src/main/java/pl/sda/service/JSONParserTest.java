package pl.sda.service;


import org.junit.Test;
import pl.sda.model.Coord;
import pl.sda.model.Location;

class JSONParserTest {

    @Test
    void shouldAddLocationObjectToJSONWithAllParameters() {
        //given
        Coord coord = new Coord(50, 50);
        Location location = new Location("EU", "Poland", coord);
        JSONParser jsonParser = new JSONParser();
        //when
        jsonParser.addLocationObjectToJSON(location);
        //then


    }
}