package restdemo;



import hote.entity.User;
import hotel.persistence.GenericDao;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/greeting")
public class HelloWorld {
    GenericDao genericDao = new GenericDao(User.class);


    // The Java method will process HTTP GET requests
    @GET
    @Path("/{param}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces({"text/plain", "text/html", "text/json"})
    public Response getMessage(@PathParam("param") int msg) {

        User retrievedUser = (User)genericDao.getById(msg);


        //List<User> allUsers = dao.getAll();
        //String one = dao.getById(msg);
       //List<User> user = dao.getById(msg);
        // Return a simple message

        //String Html = "<br><html><body><h1>Hello: " + retrievedUser  + "</h1></body></html>";
        String json = "{\"Hello\":\"" + retrievedUser + "\"}";



        return Response.status(200).entity(json).build();


    }

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces({"text/html"})
    public Response getMessage1() {

        List<User> users = genericDao.getAll();
        // Return a simple message
        //String output = "Data: " + users;
        String Html = "<br><html><body><h1>data: " + users + "</h1></body></html>";
        //String json = "{\"Hello\":\"\"}";

        return Response.status(200).entity(Html).build();
    }

}