package com.myfinance.service;

import com.myfinance.model.Usuario;
import com.myfinance.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordService passwordService;

    public List<Usuario> findAll() {
        return usuarioRepository.findByEstado('A');
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Optional<Usuario> findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario save(Usuario usuario) {
        usuario.setPassword(passwordService.encryptPassword(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> update(Long id, Usuario usuarioDetails) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setCorreo(usuarioDetails.getCorreo());
            if (usuarioDetails.getPassword() != null) {
                usuario.setPassword(passwordService.encryptPassword(usuarioDetails.getPassword()));
            }
            usuario.setEstado(usuarioDetails.getEstado());
            return usuarioRepository.save(usuario);
        });
    }

    public boolean delete(Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuarioRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public boolean validateUserPassword(Long userId, String password) {
        Optional<Usuario> usuario = usuarioRepository.findById(userId);
        return usuario.map(u -> passwordService.validatePassword(password, u.getPassword()))
                     .orElse(false);
    }
}