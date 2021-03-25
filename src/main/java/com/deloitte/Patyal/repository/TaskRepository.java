package com.deloitte.Patyal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.deloitte.Patyal.model.Task;

/**
 * The Task Repository interface extends the <code>CrudRepository</code> class. It has two
 * abstract methods which inturn executes two queries in the Database. One query
 * is to select all the tasks from the Database for a corresponding userId and
 * the next query is to toggle between completed and the not completed.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */
@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Integer> {

	@Query("SELECT t from Task t where t.userId =:user_Id ")
	List<Task> findTasks(int user_Id);

	@Transactional
	@Modifying
	@Query("UPDATE Task SET completed = :completed where taskId =:task_Id ")
	Integer updateCompleted(Boolean completed, int task_Id);

}
