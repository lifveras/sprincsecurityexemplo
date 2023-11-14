package edu.ifsp.ltp.exemplo_springsecurity.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.ifsp.ltp.exemplo_springsecurity.model.Usuario;

public class MyUserDetails implements UserDetails{
    // Representa o usuário que vem do banco de dados
    private Usuario usuarioDoSitema;

    public MyUserDetails(Usuario usuario){
        this.usuarioDoSitema = usuario;
    }

    // Métodos obrigatórios que devem ser implementados
    @Override
    // Ignorar este método
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return null;
    }

    @Override
    public String getPassword() {
        return this.usuarioDoSitema.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarioDoSitema.getUsername();
    }

    @Override
    // Ignorar este método
    public boolean isAccountNonExpired() {
     return true;
    }

    @Override
    // Ignorar este método
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // Ignorar este método
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    // Ignorar este método
    public boolean isEnabled() {
        return true;
    }
}
