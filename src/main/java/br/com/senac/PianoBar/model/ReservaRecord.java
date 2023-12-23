
package br.com.senac.PianoBar.model;

import java.time.LocalDate;

/**
 *
 * @author davi_
 */
public record ReservaRecord(Long id, String nome, String cpf, String email, LocalDate data, int mesa) {
    
    public ReservaRecord(Reserva reserva){
        this(reserva.getId(), reserva.getNome(), reserva.getCpf(), reserva.getEmail(), reserva.getData(), reserva.getMesa());
    }
}
