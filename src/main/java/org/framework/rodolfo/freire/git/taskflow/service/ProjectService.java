package org.framework.rodolfo.freire.git.taskflow.service;

import org.framework.rodolfo.freire.git.taskflow.document.Project;
import org.framework.rodolfo.freire.git.taskflow.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements GenericsInterfaceService<Project> {

    final
    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<Project> findAllPage(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
