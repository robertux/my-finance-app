package com.myfinance.controller;

import com.myfinance.dto.LoginRequest;
import com.myfinance.model.Usuario;
import com.myfinance.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Usuario> usuario = usuarioService.findByUsuario(loginRequest.getUsuario());
        
        if (usuario.isPresent() && usuarioService.validateUserPassword(usuario.get().getId(), loginRequest.getPassword())) {
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}