package com.deloitte.Patyal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.deloitte.Patyal.model.User;

/**
 * This User Repository interface extends the <code>CrudRepository</code> class.
 * It has two abstract methods which inturn executes two queries in the
 * Database. One query is to select the userName for the corresponding userId
 * and the next query is to select password for a corresponding userId.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("select password from User  where userName = ?1")
	String findPassword(String user_name);

	@Query("select userId from User  where userName = ?1")
	int findUserId(String user_name);
}
