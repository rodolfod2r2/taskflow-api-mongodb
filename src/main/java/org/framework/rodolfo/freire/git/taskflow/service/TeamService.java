package org.framework.rodolfo.freire.git.taskflow.service;

import org.framework.rodolfo.freire.git.taskflow.document.Team;
import org.framework.rodolfo.freire.git.taskflow.repository.TeamRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements GenericsInterfaceService<Team> {

    final
    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Page<Team> findAllPage(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(String id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
