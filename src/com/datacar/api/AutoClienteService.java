package com.datacar.api;


import com.datacar.model.AutoCliente;
import com.datacar.persistence.*;
import com.datacar.utility.AutoEntityToDto;
import com.datacar.utility.ClienteEntityToDto;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/cliente/auto")
public class AutoClienteService {

    @EJB
    AutoClienteRepository autoClienteRepository;

    @EJB
    ClienteRepository clienteRepository;

    @EJB
    AutoRepository autoRepository;



    //TODO refactor the post req and the autocliente in order to pass the values of the auto and find the id

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAutoCliente(AutoCliente autoCliente){
        try {
            String targa = autoCliente.getTarga();
            ClienteEntity clienteEntity = clienteRepository.findClienteByCodFiscale(autoCliente.getCod_fiscale());
            System.out.println(autoCliente.getAuto_id());
            AutoEntity autoEntity = autoRepository.getAutoById(autoCliente.getAuto_id());
            System.out.println(autoEntity.getMarca());
            autoClienteRepository.createAutoCliente(targa, clienteEntity, autoEntity);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GET
    @Path("/{cod_fiscale}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAutoOfCliente(@PathParam("cod_fiscale") String cod_fiscale){
        ClienteEntity clienteEntity = clienteRepository.findClienteByCodFiscale(cod_fiscale);
        List<AutoEntity> list_of_auto= autoClienteRepository.getAllClienteAuto(clienteEntity);
        return Response.status(Response.Status.OK).entity(AutoEntityToDto.getListAutoDTOFromAutoEntityList(list_of_auto)).build();
    }
}
