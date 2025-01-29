package com.myfinance.service;

import com.myfinance.model.Transaccion;
import com.myfinance.model.Cuenta;
import com.myfinance.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private CuentaService cuentaService;

    private void validateTransactionDate(Timestamp fecha) {
        if (fecha.after(new Timestamp(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("Transaction date cannot be in the future");
        }
    }

    private void validateTransactionAmount(Double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
    }

    private void validateSufficientFunds(Cuenta cuenta, Double monto, String tipo) {
        if (tipo.equals("D") && cuenta.getSaldo().doubleValue() < monto) {
            throw new IllegalStateException("Insufficient funds");
        }
    }

    public List<Transaccion> findAll() {
        return transaccionRepository.findByEstado("A");
    }

    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    public Transaccion save(Transaccion transaccion) {
        validateTransactionDate(transaccion.getFecha());
        validateTransactionAmount(transaccion.getMonto());
        
        Optional<Cuenta> cuenta = cuentaService.findById(transaccion.getCuentaId());
        cuenta.ifPresent(c -> validateSufficientFunds(c, transaccion.getMonto(), transaccion.getTipo()));
        return transaccionRepository.save(transaccion);
    }

    public boolean deleteById(Long id) {
        if (transaccionRepository.existsById(id)) {
            transaccionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Transaccion> update(Long id, Transaccion transaccionDetails) {
        return transaccionRepository.findById(id)
            .map(transaccion -> {
                transaccion.setCuentaId(transaccionDetails.getCuentaId());
                transaccion.setMonto(transaccionDetails.getMonto());
                transaccion.setTipo(transaccionDetails.getTipo());
                transaccion.setFecha(transaccionDetails.getFecha());
                transaccion.setEstado(transaccionDetails.getEstado());
                transaccion.setDescripcion(transaccionDetails.getDescripcion());
                transaccion.setConfirmacion(transaccionDetails.getConfirmacion());
                transaccion.setEtiqueta(transaccionDetails.getEtiqueta());
                return transaccionRepository.save(transaccion);
            });
    }
}