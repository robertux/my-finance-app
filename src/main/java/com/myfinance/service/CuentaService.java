package com.myfinance.service;

import com.myfinance.model.Cuenta;
import com.myfinance.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

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

    private void validateBalance(BigDecimal newBalance) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Account balance cannot be negative");
        }
    }

    private void validateAccountStatus(Character estado) {
        if (estado != 'A') {
            throw new IllegalStateException("Account is not active");
        }
    }

    public Optional<Cuenta> update(Long id, Cuenta cuentaDetails) {
        return cuentaRepository.findById(id)
            .map(cuenta -> {
                validateAccountStatus(cuenta.getEstado());
                validateBalance(cuentaDetails.getSaldo());
                cuenta.setNumero(cuentaDetails.getNumero());
                cuenta.setEstado(cuentaDetails.getEstado());
                cuenta.setSaldo(cuentaDetails.getSaldo());
                cuenta.setUsuarioId(cuentaDetails.getUsuarioId());
                return cuentaRepository.save(cuenta);
            });
    }
}