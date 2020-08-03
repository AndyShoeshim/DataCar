package com.datacar.api;


import com.datacar.controller.OfficinaClienteRepository;
import com.datacar.controller.OfficinaRepository;
import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;
import com.datacar.controller.ClienteRepository;
import com.datacar.persistence.OfficinaEntity;
import com.datacar.utility.ClienteEntityToDto;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
public class ClienteService {

    @EJB
    ClienteRepository clienteRepository;

    @EJB
    OfficinaRepository officinaRepository;

    @EJB
    OfficinaClienteRepository officinaClienteRepository;

   /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCliente(){
        List<ClienteEntity> clienteEntities = clienteRepository.getAllCliente();
        return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getListClienteDTOfromListEntity(clienteEntities)).build();
    }
    */

    @POST
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_officina}")
    public Response getAllClienteOfOfficina(@PathParam("id_officina") int id_officina){
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
        List<ClienteEntity> clienteEntities = officinaClienteRepository.getClienteListOfOfficina(officinaEntity);
        return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getListClienteDTOfromListEntity(clienteEntities)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente){
        try {
            //TODO CONSIDER HEAVY REFACTOR OF THIS SERVICE
            clienteRepository.createCliente(cliente);
            OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(cliente.getId_officina());
            ClienteEntity clienteEntity = clienteRepository.findClienteByCodFiscale(cliente.getCod_fiscale());
            officinaClienteRepository.createOfficinaCliente(officinaEntity,clienteEntity);
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
