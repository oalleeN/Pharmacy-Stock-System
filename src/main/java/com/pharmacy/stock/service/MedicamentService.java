package com.pharmacy.stock.service;

import com.pharmacy.stock.model.Medicament;
import com.pharmacy.stock.repository.MedicamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {

    private final MedicamentRepository repository;

    public MedicamentService(MedicamentRepository repository) {
        this.repository = repository;
    }

    public List<Medicament> listAll() {
        return repository.findAll();
    }

    public Medicament save(Medicament medicament) {
        return repository.save(medicament);
    }

    public Optional<Medicament> findById(Long id) {
        return repository.findById(id);
    }

    public Medicament findByCode(String code) {
        return repository.findByCode(code);
    }

    public Medicament update(Long id, Medicament dados) {
        dados.setId(id);
        return repository.save(dados);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
