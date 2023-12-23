
package br.com.senac.PianoBar.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davi_
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    
    @Query(value = "select * from login where cast(aes_decrypt(cpf,'bm9327') as char(50)) = (:cpf) and cast(aes_decrypt(senha,'bm9327') as char(50)) = (:senha)", nativeQuery = true)
    Login buscarLogin(@Param("cpf")String cpf, @Param("senha") String senha);
   
}
