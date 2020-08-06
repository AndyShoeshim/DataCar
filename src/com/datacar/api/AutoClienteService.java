package com.datacar.api;


import com.datacar.controller.AutoClienteRepository;
import com.datacar.controller.AutoRepository;
import com.datacar.controller.ClienteRepository;
import com.datacar.model.AutoCliente;
import com.datacar.persistence.*;
import com.datacar.utility.AutoEntityToDto;
import com.datacar.utility.ClienteEntityToDto;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/autocliente")
public class AutoClienteService {

    @EJB
    AutoClienteRepository autoClienteRepository;

    @EJB
    ClienteRepository clienteRepository;

    @EJB
    AutoRepository autoRepository;



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAutoCliente(AutoCliente autoCliente){
        try {
            String targa = autoCliente.getTarga();
            ClienteEntity clienteEntity = clienteRepository.findClienteByCodFiscale(autoCliente.getCod_fiscale());
            String marca = autoCliente.getMarca();
            String modello = autoCliente.getModello();
            String cilindrata = autoCliente.getCilindrata();
            String motore = autoCliente.getMotore();
            String carburante = autoCliente.getCarburante();
            AutoEntity autoEntity = autoRepository.getAutoByDesc(marca,modello,cilindrata,motore,carburante);
            System.out.println(autoEntity.getMarca());
            autoClienteRepository.createAutoCliente(targa, clienteEntity, autoEntity);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GET
    @Path("/auto/{cod_fiscale}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAutoOfCliente(@PathParam("cod_fiscale") String cod_fiscale){
        ClienteEntity clienteEntity = clienteRepository.findClienteByCodFiscale(cod_fiscale);
        List<AutoEntity> list_of_auto= autoClienteRepository.getAllClienteAuto(clienteEntity);
        return Response.status(Response.Status.OK).entity(AutoEntityToDto.getListAutoDTOFromAutoEntityList(list_of_auto)).build();
    }

    @GET
    @Path("/cliente/{targa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteFromTarga(@PathParam("targa") String targa){
        ClienteEntity clienteEntity = autoClienteRepository.getClienteByTarga(targa);
        return Response.status(Response.Status.OK).entity(ClienteEntityToDto.getClienteDTOfromEntity(clienteEntity)).build();
    }
}
