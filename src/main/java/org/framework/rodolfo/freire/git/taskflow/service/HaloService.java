package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.Halo;
import org.framework.rodolfo.freire.git.taskflow.repository.HaloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaloService implements GenericsInterfaceService<Halo> {

    final
    HaloRepository haloRepository;

    public HaloService(HaloRepository haloRepository) {
        this.haloRepository = haloRepository;
    }

    @Override
    public Page<Halo> findAllPage(Pageable pageable) {
        return haloRepository.findAll(pageable);
    }

    @Override
    public List<Halo> findAll() {
        return haloRepository.findAll();
    }

    @Override
    public Optional<Halo> findById(String id) {
        return haloRepository.findById(id);
    }

    @Override
    public Halo save(Halo halo) {
        return haloRepository.save(halo);
    }
}
