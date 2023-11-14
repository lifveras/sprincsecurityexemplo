package edu.ifsp.ltp.exemplo_springsecurity.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.ifsp.ltp.exemplo_springsecurity.model.Usuario;
import edu.ifsp.ltp.exemplo_springsecurity.repository.UsuarioRepository;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarioCredenciais = usuarioRepository.findByUsername(username);
        if(usuarioCredenciais == null)
            throw new UsernameNotFoundException(username);

        return new MyUserDetails(usuarioCredenciais);
    }   
}
