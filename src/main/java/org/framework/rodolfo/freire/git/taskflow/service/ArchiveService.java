package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.Archive;
import org.framework.rodolfo.freire.git.taskflow.repository.ArchiveRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveService implements GenericsInterfaceService<Archive> {

    final
    ArchiveRepository archiveRepository;

    public ArchiveService(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    @Override
    public Page<Archive> findAllPage(Pageable pageable) {
        return archiveRepository.findAll(pageable);
    }

    @Override
    public List<Archive> findAll() {
        return archiveRepository.findAll();
    }

    @Override
    public Optional<Archive> findById(String id) {
        return archiveRepository.findById(id);
    }

    @Override
    public Archive save(Archive archive) {
        return archiveRepository.save(archive);
    }
}