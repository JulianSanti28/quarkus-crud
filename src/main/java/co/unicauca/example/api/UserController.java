package co.unicauca.example.api;

import co.unicauca.example.model.User;
import co.unicauca.example.service.IUserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/user")
@RequiredArgsConstructor(onConstructor = @__ (@Inject))
public class UserController {
    private final IUserService userService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsers(){
        return Response.ok(this.userService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response findUserById(@PathParam(value = "userId") Long userId){
        return this.userService.findById(userId).of();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(User payload){
        return Response.ok(this.userService.saveUser(payload)).build();
    }

}
