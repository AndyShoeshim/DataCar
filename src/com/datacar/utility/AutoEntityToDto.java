package com.datacar.utility;

import com.datacar.model.Auto;
import com.datacar.persistence.AutoEntity;

import java.util.ArrayList;
import java.util.List;

public class AutoEntityToDto {

    public static Auto getAutoDTOFromAutoEntity(AutoEntity autoEntity){
        String marca = autoEntity.getMarca();
        String modello = autoEntity.getModello();
        String motore = autoEntity.getMotore();
        String cilindrata = autoEntity.getCilindrata();
        String carburante = autoEntity.getCarburante();
        String cavalli = autoEntity.getCavalli();
        Auto auto = new Auto(marca,modello,motore,cilindrata,carburante,cavalli);
        return auto;
    }

    public static List<Auto> getListAutoDTOFromAutoEntityList(List<AutoEntity> autoEntities){
        List<Auto> autoList = new ArrayList<>();
        for(AutoEntity autoEntity : autoEntities){
            autoList.add(getAutoDTOFromAutoEntity(autoEntity));
        }

        return autoList;
    }
}
