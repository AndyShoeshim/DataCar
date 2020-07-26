package com.datacar.api;


import com.datacar.model.AutoCliente;
import com.datacar.persistence.*;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
            AutoEntity autoEntity = autoRepository.getAutoById(autoCliente.getAuto_id());
            autoClienteRepository.createAutoCliente(targa, clienteEntity, autoEntity);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
