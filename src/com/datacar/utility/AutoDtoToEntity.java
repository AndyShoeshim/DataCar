package com.datacar.utility;

import com.datacar.model.Auto;
import com.datacar.persistence.AutoEntity;

public class AutoDtoToEntity {

    public static AutoEntity autoEntityFromautoDto(Auto auto){
        String marca = auto.getMarca();
        String modello = auto.getModello();
        String motore = auto.getMotore();
        String cilindrata = auto.getCilindrata();
        String carburante = auto.getCarburante();
        String cavalli = auto.getCavalli();
        return new AutoEntity(marca,modello,motore,cilindrata,carburante,cavalli);
    }
}
