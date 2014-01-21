package pl.ktif.ttlz.dao;

import org.springframework.stereotype.Repository;

import pl.ktif.ttlz.model.User;

@Repository
public interface UserDAO extends org.springframework.data.jpa.repository.JpaRepository<User, Integer> {

	User findByName(final String name);

	User findById(final Integer id);

}
