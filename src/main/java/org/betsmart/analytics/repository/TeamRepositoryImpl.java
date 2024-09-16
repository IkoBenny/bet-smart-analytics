package org.betsmart.analytics.repository;

import java.util.Optional;

import org.betsmart.analytics.entity.Team;

import jakarta.persistence.EntityManager;

public class TeamRepositoryImpl implements TeamRepository {
EntityManager entityManager;
	
    public TeamRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Optional<Team> save(Team team) {
        try {
            entityManager.getTransaction().begin();
            if (team.getId() == null) {
                entityManager.persist(team);
            } else {
                team = entityManager.merge(team);
            }
            entityManager.getTransaction().commit();

            return Optional.of(team);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    
    @Override
    public Optional<Team> getTeamById(Long id) {
        Team team = entityManager.find(Team.class, id);
        return team != null ? Optional.of(team) : Optional.empty();
    }
    
    @Override
    public void deleteTeam(Team team) {
        entityManager.getTransaction().begin();

        if (entityManager.find(Team.class ,team.getId()) != null) {
            entityManager.remove(team);
        } else {
            entityManager.merge(team);
        }

        entityManager.getTransaction().commit();
    }
}
