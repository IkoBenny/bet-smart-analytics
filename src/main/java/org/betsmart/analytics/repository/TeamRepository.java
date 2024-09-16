package org.betsmart.analytics.repository;

import java.util.Optional;

import org.betsmart.analytics.entity.Team;

public interface TeamRepository {
    Optional<Team> save(Team team);
    Optional<Team> getTeamById(Long id);
    void deleteTeam(Team team);
}
