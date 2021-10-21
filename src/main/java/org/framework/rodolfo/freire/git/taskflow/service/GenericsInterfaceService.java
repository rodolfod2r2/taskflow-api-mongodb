package org.framework.rodolfo.freire.git.taskflow.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GenericsInterfaceService<T> {

    Page<T> findAllPage(Pageable pageable);

    List<T> findAll();

    Optional<T> findById(String id);

    T save(T t);
}
