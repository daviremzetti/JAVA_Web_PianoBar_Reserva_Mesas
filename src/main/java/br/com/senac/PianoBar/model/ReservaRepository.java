
package br.com.senac.PianoBar.model;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davi_
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    @Query(value="select mesa from reserva where data =(:data)", nativeQuery = true)
    List<Integer> buscarMesas(LocalDate data);
    
    @Query(value="select * from reserva where nome like %:texto% or cpf like %:texto% or mesa like %:texto% or data like %:texto%", nativeQuery = true)
    List<Reserva> buscar(String texto);
    
    Page<Reserva> findAllByOrderByDataDesc(Pageable paginacao);
    Page<Reserva> findAllByOrderByNomeAsc(Pageable paginacao);
    Page<Reserva> findAllByOrderByCpfAsc(Pageable paginacao);
    Page<Reserva> findAllByOrderByMesaAsc(Pageable paginacao);
}
