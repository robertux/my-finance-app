package com.myfinance.service;

import com.myfinance.model.Transaccion;
import com.myfinance.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    public List<Transaccion> findAll() {
        return transaccionRepository.findAll();
    }

    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    public Transaccion save(Transaccion transaccion) {
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