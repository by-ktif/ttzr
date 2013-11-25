package pl.ktif.ttlz.dao;

import org.springframework.stereotype.Repository;

import pl.ktif.ttlz.model.Tournament;

@Repository
public interface TournamentDAO extends org.springframework.data.jpa.repository.JpaRepository<Tournament, Long> {

	Tournament findByName(final String name);

	Tournament findById(final Long id);

}
