package org.betsmart.analytics.util;

import org.betsmart.analytics.entity.Team;
import org.betsmart.analytics.repository.TeamRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TeamExtractor {
		EntityManagerFactory entityManagerFactory;
		EntityManager entityManager;
		TeamRepositoryImpl teamRepository;
		Team team;
		
		public TeamExtractor() {
			super();
			entityManagerFactory = Persistence.createEntityManagerFactory("default");
			entityManager = entityManagerFactory.createEntityManager();
			teamRepository = new TeamRepositoryImpl(entityManager);
		}

		public void extract(String line) {
			String[] values = line.split(",");

			String name = values[0];
			team = new Team();
			team.setName(name);
			
			teamRepository.save(team);

		}
		
		public void cleanup() {
	        entityManager.close();
	        entityManagerFactory.close();
		}

		public static void main(String[] args) {
	        FileTraverser travel = new FileTraverser("./teams/teams.txt");
	        travel.traverse();
		}

		public Team getTeam() {
			return team;
		}

		public void setTeamRepository(TeamRepositoryImpl teamRepository) {
			this.teamRepository = teamRepository;
		}
}
