package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.History;
import org.framework.rodolfo.freire.git.taskflow.repository.HistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService implements GenericsInterfaceService<History> {

    final
    HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public Page<History> findAllPage(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> findById(String id) {
        return historyRepository.findById(id);
    }

    @Override
    public History save(History history) {
        return historyRepository.save(history);
    }
}
