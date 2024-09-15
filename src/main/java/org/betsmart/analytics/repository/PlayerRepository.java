package org.betsmart.analytics.repository;

import java.util.Optional;

import org.betsmart.analytics.entity.Player;

public interface PlayerRepository {
	    Optional<Player> save(Player player);
	    Optional<Player> getPlayerById(Long id);
	    void deletePlayer(Player player);
}
