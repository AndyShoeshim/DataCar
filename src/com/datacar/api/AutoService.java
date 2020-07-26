package com.datacar.api;


import com.datacar.model.Auto;
import com.datacar.persistence.AutoRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auto")
public class AutoService {

    @EJB
    AutoRepository autoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAuto(){
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAuto(Auto auto){
        if(auto!=null){
            autoRepository.createAuto(auto);
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
