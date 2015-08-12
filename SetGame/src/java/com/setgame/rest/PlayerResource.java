package com.setgame.rest;


import com.setgame.business.PlayerBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/player")
public class PlayerResource {
    
    private PlayerBean playerBean;
    
    @EJB
    public void setPlayerBean(PlayerBean b) {
        //System.out.println(">>> injecting Player bean");
        playerBean = b;
    }
    
    @Path("{playerName}/{password}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(@PathParam("playerName")String playerName, @PathParam("password")String password) {
        
        System.out.println("From Url : "+playerName+ " "+password);
        
        boolean flag= playerBean.authenticate(playerName,password);
        //System.out.println(">>>> Player bean return = " + flag);
        if (flag)
        {
            //System.out.println("Correct");
            
            JsonObject jo = Json.createObjectBuilder()
                    .add("authenticate",flag)
                    .build();
            
            return Response.ok(jo).build();
        }
        else
        {
            //System.out.println("InCorrect");
            
            JsonObject jo = Json.createObjectBuilder()
                    .add("authenticate",flag)
                    .build();
            
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        
    }
    
    @GET
    @Path("/createAccount")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@QueryParam("playerName") String playerName, @QueryParam("password") String password)
    {
        System.out.println("From Parameter .. >> "+playerName + " "+password);
        
        if(playerName.equals("") || password.equals(""))
        {
            JsonObject jo = Json.createObjectBuilder()
                    .add("createSuccess",false)
                    .build();
            
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else{
        
        playerBean.createacc(playerName, password);
        
          JsonObject jo = Json.createObjectBuilder()
                    .add("createSuccess",true)
                    .build();
            
            return Response.ok(jo).build();
        }
    }
    
    
    
}
