package org.betsmart.analytics.repository;

import java.util.Optional;

import org.betsmart.analytics.entity.Player;

import jakarta.persistence.EntityManager;

public class PlayerRepositoryImpl implements PlayerRepository {
	EntityManager entityManager;
	
    public PlayerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Optional<Player> save(Player player) {
        try {
            entityManager.getTransaction().begin();
            if (player.getId() == null) {
                entityManager.persist(player);
            } else {
                player = entityManager.merge(player);
            }
            entityManager.getTransaction().commit();

            return Optional.of(player);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    
    @Override
    public Optional<Player> getPlayerById(Long id) {
        Player player = entityManager.find(Player.class, id);
        return player != null ? Optional.of(player) : Optional.empty();
    }
    
    @Override
    public void deletePlayer(Player player) {
        entityManager.getTransaction().begin();

        if (entityManager.find(Player.class ,player.getId()) != null) {
            entityManager.remove(player);
        } else {
            entityManager.merge(player);
        }

        entityManager.getTransaction().commit();
    }
}
