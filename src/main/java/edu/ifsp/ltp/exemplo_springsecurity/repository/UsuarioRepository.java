package edu.ifsp.ltp.exemplo_springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.ltp.exemplo_springsecurity.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
