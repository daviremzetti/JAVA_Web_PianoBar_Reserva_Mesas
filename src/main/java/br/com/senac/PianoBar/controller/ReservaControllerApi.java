
package br.com.senac.PianoBar.controller;

import br.com.senac.PianoBar.model.Reserva;
import br.com.senac.PianoBar.model.ReservaRecord;
import br.com.senac.PianoBar.service.ReservaService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davi_
 */
@RestController
@RequestMapping("/pianoBarApi")
@CrossOrigin(origins = "*")
public class ReservaControllerApi {
    
    @Autowired
    private ReservaService service;
    
    @GetMapping("/{data}")
    public List<Integer> buscarMesasLivres(@PathVariable LocalDate data){
        return service.buscarMesasLivres(data);
    }
    
    @PostMapping
    public ResponseEntity<Reserva> cadastrarReserva(@RequestBody @Valid Reserva reserva){
        var novaReserva = service.cadastrarReserva(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }
    
    @GetMapping("/data")
    public Page<ReservaRecord> ordenarDataPaginacao(@PageableDefault(size=10) Pageable paginacao){
        return service.ordenarDataPaginacao(paginacao);
    }
    
    @GetMapping("/nome")
    public Page<ReservaRecord> ordenarNome(@PageableDefault(size=10) Pageable paginacao){
        return service.ordenarNome(paginacao);
    }
    
    @GetMapping("/cpf")
    public Page<ReservaRecord>ordenarCpf(@PageableDefault(size=10) Pageable paginacao){
        return service.ordenarCpf(paginacao);
    }
    
    @GetMapping("/mesa")
    public Page<ReservaRecord> ordenarMesa(@PageableDefault(size=10) Pageable paginacao){
        return service.ordenarMesa(paginacao);
    }
    
    @GetMapping("/buscar/{texto}")
    public List<Reserva> buscar(@PathVariable String texto){
        return service.buscar(texto);
    }
}
