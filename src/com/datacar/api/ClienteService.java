package com.datacar.api;


import com.datacar.controller.AutoClienteRepository;
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
import java.util.ArrayList;
import java.util.List;

@Path("/cliente")
public class ClienteService {

    @EJB
    ClienteRepository clienteRepository;

    @EJB
    OfficinaRepository officinaRepository;

    @EJB
    OfficinaClienteRepository officinaClienteRepository;

    @EJB
    AutoClienteRepository autoClienteRepository;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_officina}")
    public Response getAllClienteOfOfficina(@PathParam("id_officina") int id_officina){
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);

        List<ClienteEntity> clienteEntities = officinaClienteRepository.getClienteListOfOfficina(officinaEntity);
        List<Cliente> clienteDTOList = new ArrayList<>();

        for(ClienteEntity entity : clienteEntities){
            int num_targhe_associate = autoClienteRepository.getAllClienteAuto(entity).size();
            Cliente clienteDTO = ClienteEntityToDto.getClienteDTOfromEntity(entity,num_targhe_associate);
            clienteDTOList.add(clienteDTO);
        }
        return Response.status(Response.Status.OK).entity(clienteDTOList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_officina}/{id_cliente}")
    public Response getClienteFromId(@PathParam("id_officina") int id_officina, @PathParam("id_cliente") int id_cliente){
        try {

            OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
            boolean isFound=false;

            List<ClienteEntity> clienteEntities = officinaClienteRepository.getClienteListOfOfficina(officinaEntity);
            for(ClienteEntity clienteEntity : clienteEntities){
                if(clienteEntity.getId()==id_cliente)
                    isFound=true;

            }

            if(isFound) {
                ClienteEntity clienteFound = clienteRepository.findClienteById(id_cliente);
                int num_targhe_associate = autoClienteRepository.getAllClienteAuto(clienteFound).size();
                return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getClienteDTOfromEntity(clienteFound,num_targhe_associate)).build();
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
    @Path("/{id_cliente}")
    public Response updateCliente(@PathParam("id_cliente") int id_cliente, Cliente cliente){
        boolean result = clienteRepository.updateCliente(id_cliente,cliente);
        if(result)
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id_officina}/{cod_fiscale}")
    public Response deleteCliente(@PathParam("id_officina") int id_officina, @PathParam("cod_fiscale") String cod_fiscale){
        ClienteEntity clienteToDelete = clienteRepository.findClienteByCodFiscale(cod_fiscale);
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
        boolean resultFromAutoCliente = autoClienteRepository.deleteByCliente(clienteToDelete);
        boolean resultFromOfficinaCliente = officinaClienteRepository.deleteByCliente(officinaEntity,clienteToDelete);
        boolean resultFromCliente = clienteRepository.deleteClienteByCodFiscale(cod_fiscale);
        if(resultFromAutoCliente && resultFromCliente && resultFromOfficinaCliente)
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
