package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.Remark;
import org.framework.rodolfo.freire.git.taskflow.repository.RemarkRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemarkService implements GenericsInterfaceService<Remark> {

    final
    RemarkRepository remarkRepository;

    public RemarkService(RemarkRepository remarkRepository) {
        this.remarkRepository = remarkRepository;
    }

    @Override
    public Page<Remark> findAllPage(Pageable pageable) {
        return remarkRepository.findAll(pageable);
    }

    @Override
    public List<Remark> findAll() {
        return remarkRepository.findAll();
    }

    @Override
    public Optional<Remark> findById(String id) {
        return remarkRepository.findById(id);
    }

    @Override
    public Remark save(Remark remark) {
        return remarkRepository.save(remark);
    }
}
