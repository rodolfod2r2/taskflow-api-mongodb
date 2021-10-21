package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.Family;
import org.framework.rodolfo.freire.git.taskflow.repository.FamilyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService implements GenericsInterfaceService<Family> {

    final
    FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public Page<Family> findAllPage(Pageable pageable) {
        return familyRepository.findAll(pageable);
    }

    @Override
    public List<Family> findAll() {
        return familyRepository.findAll();
    }

    @Override
    public Optional<Family> findById(String id) {
        return familyRepository.findById(id);
    }

    @Override
    public Family save(Family family) {
        return familyRepository.save(family);
    }
}
