
package br.com.senac.PianoBar.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davi_
 */
@Service
public class LoginService {
    
    @Autowired
    private LoginRepository repository;
    
    public boolean logar(LoginRecord loginRecord){
        Login login = repository.buscarLogin(loginRecord.cpf(), loginRecord.senha());
        boolean logado = false;
        if(login == null){
            logado = false;
        }else{
            logado = true;
        }
        return logado;
    }
}
