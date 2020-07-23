package com.datacar.api;


import com.datacar.model.Officina;
import com.datacar.persistence.OfficinaRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/officina")
public class OfficinaService {

    @EJB
    OfficinaRepository officinaRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOfficina(Officina officina){
        try {
            officinaRepository.createOfficina(officina);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{p_iva}")
    public Response updateOfficina(@PathParam("p_iva") String p_iva, Officina officina){
        boolean result = officinaRepository.updateOfficina(p_iva,officina);
        if(result)
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
