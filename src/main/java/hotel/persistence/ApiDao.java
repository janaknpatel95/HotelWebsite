package hotel.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hote.entity.PostalCodesItem;
import hote.entity.Weather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ApiDao {


    public Weather getPlace()  {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/postalCodeSearchJSON?username=janak&postalcode=53913&countryCode=us");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Weather zip = null;
        try {

            zip = mapper.readValue(response, Weather.class);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return zip;
    }


}


