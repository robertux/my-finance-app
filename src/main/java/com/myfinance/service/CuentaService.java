package com.myfinance.service;

import com.myfinance.model.Cuenta;
import com.myfinance.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public boolean deleteById(Long id) {
        if (cuentaRepository.existsById(id)) {
            cuentaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Cuenta> update(Long id, Cuenta cuentaDetails) {
        return cuentaRepository.findById(id)
            .map(cuenta -> {
                cuenta.setNumero(cuentaDetails.getNumero());
                cuenta.setEstado(cuentaDetails.getEstado());
                cuenta.setSaldo(cuentaDetails.getSaldo());
                cuenta.setUsuarioId(cuentaDetails.getUsuarioId());
                return cuentaRepository.save(cuenta);
            });
    }
}