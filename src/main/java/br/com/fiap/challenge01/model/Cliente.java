package br.com.fiap.challenge01.model;

import br.com.fiap.challenge01.dto.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataRegistro;

    public Cliente(ClienteDTO clienteDTO) {
    }
}
