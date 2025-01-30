package com.myfinance.controller;

import com.myfinance.dto.LoginRequest;
import com.myfinance.model.Usuario;
import com.myfinance.service.UsuarioService;
import com.myfinance.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private UsuarioService usuarioService;

     @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Usuario> usuario = usuarioService.findByUsuario(loginRequest.getUsuario());

        if (usuario.isPresent() && usuarioService.validateUserPassword(usuario.get().getId(), loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(loginRequest.getUsuario());
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            return ResponseEntity.ok().headers(headers).build();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (jwtUtil.canTokenBeRefreshed(jwt)) {
                String refreshedToken = jwtUtil.refreshToken(jwt);
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer " + refreshedToken);
                return ResponseEntity.ok().headers(headers).build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}