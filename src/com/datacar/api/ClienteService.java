package com.datacar.api;


import com.datacar.controller.OfficinaClienteRepository;
import com.datacar.controller.OfficinaRepository;
import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;
import com.datacar.controller.ClienteRepository;
import com.datacar.persistence.OfficinaEntity;
import com.datacar.utility.ClienteDtoToEntity;
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



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_officina}")
    public Response getAllClienteOfOfficina(@PathParam("id_officina") int id_officina){
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
        List<ClienteEntity> clienteEntities = officinaClienteRepository.getClienteListOfOfficina(officinaEntity);
        return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getListClienteDTOfromListEntity(clienteEntities)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_officina}/{cod_fiscale}")
    public Response getClienteFromId(@PathParam("id_officina") int id_officina, @PathParam("cod_fiscale") String cod_fiscale){
        try {
            OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);

            boolean isFound=false;
            List<ClienteEntity> clienteEntities = officinaClienteRepository.getClienteListOfOfficina(officinaEntity);
            for(ClienteEntity clienteEntity : clienteEntities){
                if(clienteEntity.getCod_fiscale().equals(cod_fiscale))
                    isFound=true;

            }

            if(isFound) {
                ClienteEntity clienteFound = clienteRepository.findClienteByCodFiscale(cod_fiscale);
                return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getClienteDTOfromEntity(clienteFound)).build();
            }
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/{id_officina}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(@PathParam("id_officina") int id_officina, Cliente cliente){
        try {
            OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
            clienteRepository.createCliente(cliente);
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
