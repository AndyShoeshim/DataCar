package com.datacar.api;


import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;
import com.datacar.persistence.ClienteRepository;
import com.datacar.utility.ClienteEntityToDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        List<ClienteEntity> clienteEntities = clienteRepository.getAllCliente();
        return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getListClienteDTOfromListEntity(clienteEntities)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cod_fiscale}")
    public Response getClienteFromId(@PathParam("cod_fiscale") String cod_fiscale){
        try {
            ClienteEntity clienteFound = clienteRepository.findClienteByCodFiscale(cod_fiscale);
            return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getClienteDTOfromEntity(clienteFound)).build();
        } catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente){
        try {
            clienteRepository.createCliente(cliente);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cod_fiscale}")
    public Response updateCliente(@PathParam("cod_fiscale") String cod_fiscale, Cliente cliente){
        boolean result = clienteRepository.updateCliente(cod_fiscale,cliente);
        if(result)
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{cod_fiscale}")
    public Response deleteCliente(@PathParam("cod_fiscale") String cod_fiscale){
        boolean result = clienteRepository.deleteCliente(cod_fiscale);
        if(result)
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
