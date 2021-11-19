package com.umanizales.cancha_inteligente.infrastructure.repositories;

import com.umanizales.cancha_inteligente.domain.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "client", schema = "public", catalog = "db_canchainteligente")
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @Column(name = "id_cli", nullable = false, length = 40)
    private String idCli;

    // Codigo para ID autoincremental "@GeneretedValue(strategy = GenerationType.IDENTITY)"
    // para que esto funcione toca poner el id en integer

    @Basic
    @Column(name = "nombre_cli", nullable = false, length = 50)
    private String nombreCli;

    @Basic
    @Column(name = "tarjeta_cli", nullable = false, length = 13)
    private String tarjetaCli;


    public ClientEntity(ClientDTO clientDTO) {

        BeanUtils.copyProperties(clientDTO,this);

        this.idCli= UUID.randomUUID().toString();

    }

    public ClientDTO toclientDTO()
    {
        ClientDTO clientDTO= new ClientDTO();
        BeanUtils.copyProperties(this,clientDTO);
        return clientDTO;
    }

}
