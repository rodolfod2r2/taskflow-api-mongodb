package org.framework.rodolfo.freire.git.taskflow.service;

import org.framework.rodolfo.freire.git.taskflow.document.Gamification;
import org.framework.rodolfo.freire.git.taskflow.repository.GamificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamificationService implements GenericsInterfaceService<Gamification> {

    final
    GamificationRepository gamificationRepository;

    public GamificationService(GamificationRepository gamificationRepository) {
        this.gamificationRepository = gamificationRepository;
    }

    @Override
    public Page<Gamification> findAllPage(Pageable pageable) {
        return gamificationRepository.findAll(pageable);
    }

    @Override
    public List<Gamification> findAll() {
        return gamificationRepository.findAll();
    }

    @Override
    public Optional<Gamification> findById(String id) {
        return gamificationRepository.findById(id);
    }

    @Override
    public Gamification save(Gamification gamification) {
        return gamificationRepository.save(gamification);
    }
}
