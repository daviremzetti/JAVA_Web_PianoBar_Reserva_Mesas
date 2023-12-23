
package br.com.senac.PianoBar.controller;

import br.com.senac.PianoBar.model.Login;
import br.com.senac.PianoBar.model.LoginRecord;
import br.com.senac.PianoBar.model.LoginService;
import br.com.senac.PianoBar.model.Reserva;
import br.com.senac.PianoBar.model.ReservaRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author davi_
 */
@Controller
public class ReservaController {
    
    @Autowired
    private ReservaRepository repository;
    
    @Autowired
    private LoginService loginService;
    
    @GetMapping("/pianobar")
    public String index(Model model){
        Reserva reserva = new Reserva();
        model.addAttribute("reserva", reserva);
        return "index"; 
    }
    
    @GetMapping("/lista_reservas")
    public String listarReservas(Model model, @CookieValue(name = "logado", defaultValue = "false")String logado, @CookieValue(name = "usuario")String usuario){
        if(logado.equals("false")){
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "lista_reservas";
    }
    
    @GetMapping("/login")
    public String login(Model model, @ModelAttribute LoginRecord loginRecord, @CookieValue(name = "logado", defaultValue = "false")String logado, HttpServletResponse response){
        if(logado.equals("false")){
            model.addAttribute("loginRecord", loginRecord);
            return "login";
        }
        return "redirect:/lista_reservas";
    }
    
    @PostMapping("/logar")
    public String logar(@ModelAttribute LoginRecord loginRecord, HttpServletResponse response){
        boolean logado = loginService.logar(loginRecord);
        Cookie cookie = new Cookie("logado", String.valueOf(logado));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(86400); //maximo 1 dia
        response.addCookie(cookie);
        
        if(logado == true){
            Cookie novoCookie = new Cookie("usuario", loginRecord.cpf());
            novoCookie.setHttpOnly(true);
            novoCookie.setMaxAge(86400);
            response.addCookie(novoCookie);
        }
        return "redirect:/login";
    }
    
    @GetMapping("/logout")
    public String logout(Model model, HttpServletResponse response){
        Cookie cookie = new Cookie("logado", "false");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        Cookie novoCookie = new Cookie("usuario","");
        novoCookie.setHttpOnly(true);
        response.addCookie(novoCookie);
        return "redirect:/login";
    }
}