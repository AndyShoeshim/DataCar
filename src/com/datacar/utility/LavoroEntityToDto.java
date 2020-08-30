package com.datacar.utility;

import com.datacar.controller.DescrizioneLavoroRepository;
import com.datacar.controller.TipoLavoroRepository;
import com.datacar.model.Lavoro;
import com.datacar.persistence.LavoroEntity;

import java.util.ArrayList;
import java.util.List;

public class LavoroEntityToDto {



    public static Lavoro getLavoroDtoFromLavoroEntity(LavoroEntity lavoroEntity){
        String targa = lavoroEntity.getTarga();
        String tipoLavoro = lavoroEntity.getId_tipo_lavoro().getCategoriaLavoro();
        String descLavoro = lavoroEntity.getId_desc_lavoro().getDescrizioneLavoro();
        int id = lavoroEntity.getId();
        Lavoro lavoro = new Lavoro(targa,tipoLavoro,descLavoro,lavoroEntity.getDataScandenza(),lavoroEntity.isEffettuato());
        lavoro.setId(id);
        return lavoro;
    }

    public static List<Lavoro> getLavoroDtoListFromLavoroEntity(List<LavoroEntity> lavoroEntities){
        List<Lavoro> lavoroList = new ArrayList<>();
        for(LavoroEntity lavoroEntity : lavoroEntities){
            lavoroList.add(getLavoroDtoFromLavoroEntity(lavoroEntity));
        }

        return lavoroList;
    }

}
