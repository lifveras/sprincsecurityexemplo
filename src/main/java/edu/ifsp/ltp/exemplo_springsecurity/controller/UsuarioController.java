package edu.ifsp.ltp.exemplo_springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.ltp.exemplo_springsecurity.model.Usuario;
import edu.ifsp.ltp.exemplo_springsecurity.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // Deverá ser acessado só se a autenticação tiver sido realizada
    @GetMapping("/conteudo")
    public String getDados(){
        return "Dados retornados com sucesso";
    }

    // Deverá ser acessado independente de autenticação
    @GetMapping("/livre")
    public String naoPrecisaDeLogin(@RequestBody Usuario user){
        return "Usuário acessou sem login";
    }

    // Deverá ser acessado independente de autenticação
    // Utilizado para criar um novo usuário
    @PostMapping("/criar")
    public String criarUsuario(@RequestBody Usuario novoUser){
        novoUser.setPassword(
            passwordEncoder.encode(novoUser.getPassword()) //Codificando a senha enviada
        );
        Usuario usuarioCriado = usuarioRepository.save(novoUser);

        if(usuarioCriado != null)
            return "Usuário criado com sucesso!";        
        
        return "Erro ao criar usuário";
    }
}
