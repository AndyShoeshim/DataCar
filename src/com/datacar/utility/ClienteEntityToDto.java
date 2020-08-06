package com.datacar.utility;

import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class ClienteEntityToDto {


    public static Cliente getClienteDTOfromEntity(ClienteEntity clienteEntity) {
        String nome = clienteEntity.getNome();
        String cognome = clienteEntity.getCognome();
        String citta = clienteEntity.getCitta();
        String cap = clienteEntity.getCap();
        String indirizzo = clienteEntity.getIndirizzo();
        String sesso = clienteEntity.getSesso();
        String cod_fiscale = clienteEntity.getCod_fiscale();
        int telefono = clienteEntity.getTelefono();
        String email;
        if(clienteEntity.getEmail()!=null)
            email = clienteEntity.getEmail();
        else
            email = "";
        //TODO Refactor cliente with factory pattern
        Cliente cliente = new Cliente(nome,cognome,citta,cap,indirizzo,sesso,cod_fiscale,telefono,email);
        return cliente;
    }

    public static List<Cliente> getListClienteDTOfromListEntity(List<ClienteEntity> clienteEntities){
        List<Cliente> clienteList = new ArrayList<>();
        for(ClienteEntity clienteEntity : clienteEntities){
            clienteList.add(getClienteDTOfromEntity(clienteEntity));
        }
        return clienteList;
    }
}
