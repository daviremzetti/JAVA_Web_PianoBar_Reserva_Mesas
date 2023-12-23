
package br.com.senac.PianoBar.service;

import br.com.senac.PianoBar.model.Reserva;
import br.com.senac.PianoBar.model.ReservaRecord;
import br.com.senac.PianoBar.model.ReservaRepository;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author davi_
 */
@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository repository;
     
    public List<Integer> buscarMesasLivres(@PathVariable LocalDate data){
        List<Integer> reservas = repository.buscarMesas(data);
        List<Integer> mesas = mesas();
        List<Integer> mesasLivres = new ArrayList<>();
        for(int mesa : mesas){
            if(reservas.contains(mesa)){
                continue;
            }
            else{
                mesasLivres.add(mesa);
            }
        }
        return mesasLivres;
    }
    
    
    public Reserva cadastrarReserva(@RequestBody @Valid Reserva reserva){
        var novaReserva = repository.save(reserva);
        return novaReserva;
    }
    
    
    private List<Integer> mesas(){
        int qtd = 24;
        int mesa = 1;
        List<Integer> mesas = new ArrayList<>();
        for(int i = 0; i < 24; i++){
            mesas.add(mesa);
            mesa = mesa+1;
            qtd = qtd+1;
        }
        return mesas;
    }
    
    
    public Page<ReservaRecord> ordenarDataPaginacao(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAllByOrderByDataDesc(paginacao).map(ReservaRecord::new);
    }
    
    public Page<ReservaRecord> ordenarNome(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAllByOrderByNomeAsc(paginacao).map(ReservaRecord::new);
    }
    
    public Page<ReservaRecord>ordenarCpf(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAllByOrderByCpfAsc(paginacao).map(ReservaRecord::new);
    }
    
    public Page<ReservaRecord> ordenarMesa(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAllByOrderByMesaAsc(paginacao).map(ReservaRecord::new);
    }
    
    public List<Reserva> buscar(String texto){
        return repository.buscar(texto);
    }
    
}
