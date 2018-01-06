package core.api.entrypoint;



import org.springframework.beans.BeanUtils;

import core.api.DTO.UserDTO;
import core.api.interfaces.UsersService;
import core.api.models.CreateResponseModel;
import core.api.models.CreateUserModel;
import core.api.service.UsersServiceImp;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsersEntryPoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CreateResponseModel createUser(CreateUserModel requestModel){

        CreateResponseModel returnModel = new CreateResponseModel();

        UserDTO userdto = new UserDTO();
        BeanUtils.copyProperties(requestModel,userdto);

        UsersService userServ = new UsersServiceImp();
        UserDTO returnedProfile = userServ.createUser(userdto);

        BeanUtils.copyProperties(returnedProfile,returnModel);

        return returnModel;
    }

}
