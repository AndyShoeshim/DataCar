package com.datacar.utility;

import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;

public class ClienteDtoToEntity {

    public static ClienteEntity clienteEntityFromClienteDto(Cliente cliente){
        String nome = cliente.getNome();
        String cognome = cliente.getCognome();
        String citta = cliente.getCitta();
        String cap = cliente.getCap();
        String indirizzo = cliente.getIndirizzo();
        String sesso = cliente.getSesso();
        String cod_fiscale = cliente.getCod_fiscale();
        int telefono = cliente.getTelefono();
        String email = cliente.getEmail();
        return new ClienteEntity(nome,cognome,citta,cap,indirizzo,sesso,cod_fiscale,telefono,email);
    }
}
