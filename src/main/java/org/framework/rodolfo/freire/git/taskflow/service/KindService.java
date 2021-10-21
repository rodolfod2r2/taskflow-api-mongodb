package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.Kind;
import org.framework.rodolfo.freire.git.taskflow.repository.KindRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KindService implements GenericsInterfaceService<Kind> {

    final
    KindRepository kindRepository;

    public KindService(KindRepository kindRepository) {
        this.kindRepository = kindRepository;
    }

    @Override
    public Page<Kind> findAllPage(Pageable pageable) {
        return kindRepository.findAll(pageable);
    }

    @Override
    public List<Kind> findAll() {
        return kindRepository.findAll();
    }

    @Override
    public Optional<Kind> findById(String id) {
        return kindRepository.findById(id);
    }

    @Override
    public Kind save(Kind kind) {
        return kindRepository.save(kind);
    }
}
