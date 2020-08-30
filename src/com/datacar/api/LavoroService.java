package com.datacar.api;

import com.datacar.controller.*;
import com.datacar.model.Lavoro;
import com.datacar.persistence.DescrizioneLavoroEntity;
import com.datacar.persistence.LavoroEntity;
import com.datacar.persistence.OfficinaEntity;
import com.datacar.persistence.TipoLavoroEntity;
import com.datacar.utility.LavoroEntityToDto;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/lavoro")
public class LavoroService {

    @EJB
    LavoroRepository lavoroRepository;

    @EJB
    TipoLavoroRepository tipoLavoroRepository;

    @EJB
    AutoClienteRepository autoClienteRepository;

    @EJB
    DescrizioneLavoroRepository descrizioneLavoroRepository;

    @EJB
    OfficinaRepository officinaRepository;



    @POST
    @Path("/{id_officina}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLavoro(@PathParam("id_officina") int id_officina, Lavoro lavoro){
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
        TipoLavoroEntity tipoLavoroEntity = tipoLavoroRepository.getLavoroEntityByDesc(lavoro.getTipoLavoro());
        DescrizioneLavoroEntity descrizioneLavoroEntity = descrizioneLavoroRepository.getLavoroEntityByDesc(lavoro.getDescLavoro());
        String targa = lavoro.getTarga();
            if(autoClienteRepository.getAutoClienteByTarga(targa)!=null){
                lavoroRepository.createLavoro(officinaEntity,lavoro,tipoLavoroEntity,descrizioneLavoroEntity);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
    }

    @GET
    @Path("/{id_officina}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLavoro(@PathParam("id_officina") int id_officina){
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
        List<LavoroEntity> lavoroEntityList = lavoroRepository.getAllLavoro(officinaEntity);
        List<Lavoro> lavoroDtoList = LavoroEntityToDto.getLavoroDtoListFromLavoroEntity(lavoroEntityList);
        return Response.status(Response.Status.OK).entity(lavoroDtoList).build();
    }

    @GET
    @Path("/{id_officina}/{cod_fiscale}")
    public Response getLavoroOfCliente(@PathParam("id_officina") int id_officina, @PathParam("cod_fiscale") String cod_fiscale){
        OfficinaEntity officinaEntity = officinaRepository.getOfficinaById(id_officina);
        List<String> targhe = autoClienteRepository.getTargaOfCliente(cod_fiscale);
        List<Lavoro> lavoroDtoList = new ArrayList<>();
        for(String targa : targhe){
            List<LavoroEntity> lavoroFound = lavoroRepository.getLavoroByTarga(targa,officinaEntity);
            for(LavoroEntity lavoroEntity : lavoroFound){
                lavoroDtoList.add(LavoroEntityToDto.getLavoroDtoFromLavoroEntity(lavoroEntity));
            }
        }
        if(lavoroDtoList.size()>0)
            return Response.status(Response.Status.OK).entity(lavoroDtoList).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }


    @PUT
    @Path("/{id_lavoro}")
    public Response updateLavoroStatus(@PathParam("id_lavoro") int id_lavoro){
        try {
            boolean resultOfUpdate = lavoroRepository.updateLavoroStatus(id_lavoro);
            if(resultOfUpdate)
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.CONFLICT).build();
        } catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //TODO select data in base a data del laovoro
    // select degli ultimi 10 lavori
}
