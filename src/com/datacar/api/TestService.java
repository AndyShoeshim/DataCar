package com.datacar.api;


import com.datacar.model.Test;
import com.datacar.persistence.TestRepository;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestService {

    @EJB
    TestRepository testRepository;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTest(Test test) {
        testRepository.createTest(test);
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
