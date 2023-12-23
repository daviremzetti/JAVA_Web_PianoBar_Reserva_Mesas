
package br.com.senac.PianoBar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author davi_
 */
@Entity
@Table(name="login")
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private byte[] cpf;
    private byte[] senha;
    
    public Login(String cpf, String senha){
        this.cpf = cpf.getBytes();
        this.senha = senha.getBytes();
    }
    
    public Login(){
        
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf.getBytes();
    }
    
    public void setSenha(String senha){
        this.senha = senha.getBytes();
    }
    
    public String getCpf(){
        return new String(this.cpf);
    }
    
    public String getSenha(){
        return new String(this.senha);
    }
    
}
