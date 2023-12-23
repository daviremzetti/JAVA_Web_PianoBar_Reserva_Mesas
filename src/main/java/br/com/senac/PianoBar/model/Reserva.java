
package br.com.senac.PianoBar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


/**
 *
 * @author davi_
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    @NotBlank(message="Informe seu nome")
    private String nome;
    @Email(message="E-mail inválido")
    private String email;
    @CPF(message="CPF inválido")
    private String cpf;
    private int mesa;
}
