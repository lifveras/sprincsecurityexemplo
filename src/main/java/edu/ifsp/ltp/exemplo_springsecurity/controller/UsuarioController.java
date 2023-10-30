package edu.ifsp.ltp.exemplo_springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.ltp.exemplo_springsecurity.model.Usuario;

@RestController
public class UsuarioController {
    // Deverá ser acessado só se a autenticação tiver sido realizada
    @GetMapping("/conteudo")
    public String getDados(){
        return "Dados retornados com sucesso";
    }

    // Deverá ser acessado independente de autenticação
    @GetMapping("/livre")
    public String loginUsuario(@RequestBody Usuario user){
        return "Usuário logado";
    }

    // Deverá ser acessado independente de autenticação
    @PostMapping("/criar")
    public String criarUsuario(@RequestBody Usuario user){
        return "Usuário criado";
    }
}
