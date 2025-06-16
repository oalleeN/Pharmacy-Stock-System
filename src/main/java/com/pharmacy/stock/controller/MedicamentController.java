package com.pharmacy.stock.controller;

import com.pharmacy.stock.model.Medicament;
import com.pharmacy.stock.service.MedicamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicaments")
public class MedicamentController {

    private final MedicamentService service;

    public MedicamentController(MedicamentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medicament> listAll(){
        return service.listAll();
    }

    @PostMapping
    public Medicament create(@RequestBody Medicament medicament) {
        return service.save(medicament);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Medicament> findByCode(@PathVariable String code) {
        Medicament medicament = service.findByCode(code);
        if (medicament != null) {
            return ResponseEntity.ok(medicament);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicament> update(@PathVariable Long id, @RequestBody Medicament medicament) {
        return ResponseEntity.ok(service.update(id, medicament));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
