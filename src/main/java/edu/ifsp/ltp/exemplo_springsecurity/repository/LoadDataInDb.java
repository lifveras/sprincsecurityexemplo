package edu.ifsp.ltp.exemplo_springsecurity.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.ifsp.ltp.exemplo_springsecurity.model.Usuario;

@Configuration
public class LoadDataInDb implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        ArrayList<Usuario> usuariosNovos = new ArrayList<>();
        usuariosNovos.add(new Usuario("orion", passwordEncoder.encode("1234")));
        usuariosNovos.add(new Usuario("estelar", passwordEncoder.encode("1234")));
        
        usuarioRepository.saveAll(usuariosNovos);
    }
}
