package com.datacar.api;


import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;
import com.datacar.persistence.ClienteRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
public class ClienteService {

    @EJB
    ClienteRepository clienteRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCliente(){
        return Response.status(Response.Status.OK).entity(clienteRepository.getAllCliente()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cod_fiscale}")
    public Response getClienteFromId(@PathParam("cod_fiscale") String cod_fiscale){
        return Response.status(Response.Status.OK).entity(clienteRepository.findClienteByCodFiscale(cod_fiscale)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente){
        clienteRepository.createCliente(cliente);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cod_fiscale}")
    public Response updateCliente(@PathParam("cod_fiscale") String cod_fiscale, Cliente cliente){
        clienteRepository.updateCliente(cod_fiscale,cliente);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{cod_fiscale}")
    public Response deleteCliente(@PathParam("cod_fiscale") String cod_fiscale){
        clienteRepository.deleteCliente(cod_fiscale);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
