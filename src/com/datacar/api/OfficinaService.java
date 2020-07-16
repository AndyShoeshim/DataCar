package com.datacar.api;


import com.datacar.model.Officina;
import com.datacar.persistence.OfficinaRepository;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/officina")
public class OfficinaService {

    @EJB
    OfficinaRepository officinaRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOfficina(Officina officina){
        officinaRepository.createOfficina(officina);
        return Response.status(Response.Status.CREATED).build();
    }


    //TODO update Officina
}
