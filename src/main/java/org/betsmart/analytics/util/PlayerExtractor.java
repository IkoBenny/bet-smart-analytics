package org.betsmart.analytics.util;

import org.betsmart.analytics.entity.Player;
import org.betsmart.analytics.repository.PlayerRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PlayerExtractor {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	PlayerRepositoryImpl playerRepository;
	Player player;
	
	public PlayerExtractor() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("default");
		entityManager = entityManagerFactory.createEntityManager();
		playerRepository = new PlayerRepositoryImpl(entityManager);
	}

	public void extract(String line) {
		String[] values = line.split(",");

		String name = values[0];
		String[] names = name.split(" ");
		String first = names[0];
		String last = names[1];

		String sYear = values[1];
		String eYear = values[2];

		String position = values[3];
		String height = values[4];
		String weight = values[5];
		String bday = values[6];
		String college = values[7];
		String id = values[8];

		player = new Player();
		player.setfName(first);
		player.setlName(last);
		player.setsYear(sYear);
		player.seteYear(eYear);
		player.setPos(position);
		player.setHeight(height);
		player.setWeight(weight);
		player.setbDay(bday);
		player.setCollege(college);
		player.setId(id);
		
		playerRepository.save(player);

	}
	
	public void cleanup() {
        entityManager.close();
        entityManagerFactory.close();
	}

	public static void main(String[] args) {
        FileTraverser travel = new FileTraverser("./players/A/a.txt");
        travel.traverse();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayerRepository(PlayerRepositoryImpl playerRepository) {
		this.playerRepository = playerRepository;
	}

}
