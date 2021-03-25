package com.deloitte.Patyal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.Patyal.model.Task;
import com.deloitte.Patyal.repository.TaskRepository;
import com.deloitte.Patyal.repository.UserRepository;

/**
 * @author billy ToDoService is the class which is executed from the
 *         ToDoController class. It has three methods. This class will create an
 *         object for the userRepository class and a taskRepository class when
 *         required. The main purpose of this class is to write down the service
 *         layer methods required for this application. It has the methods
 *         related to the crud opeerations of the To-Do tasks.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */

@Service
public class ToDoService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TaskRepository taskRepository;

	/**
	 * This method will return all the tasks from the database for a corresponding
	 * user.
	 * 
	 * @param userName This attribute will hold the userName provided by the user
	 *                 from the Login page
	 * @return return a list of all the tasks from the databse to the Controller
	 */
	public List<Task> retrieveTodos(String userName) {

		int userId = userRepository.findUserId(userName);
		List<Task> todos = taskRepository.findTasks(userId);

		return todos;
	}

	/**
	 * This method is used to add a task to the To-do task list. It adds a row to
	 * the database.
	 * 
	 * @param taskName    This attribute will hold the name of the task provided as
	 *                    input by the user.
	 * @param description This attribute will hold the description of the task
	 *                    provided as input by the user.
	 * @param priority    This attribute will hold the priority of the task provided
	 *                    as input by the user.
	 * @param name        This attribute will hold the userName of the user which
	 *                    wil be used to find the user ID.
	 * @return This will return the object of the Task bean class.
	 */
	public Task addTodo(String taskName, String description, int priority, String name) {
		int num = 0;
		int userId = userRepository.findUserId(name);
		Task task = new Task(num, taskName, description, new Date(), priority, false, userId);
		return taskRepository.save(task);
	}

	/**
	 * @param id This will hold the Task ID integer given as input by the user.
	 */
	public void deleteTodo(Integer id) {
		
		System.out.println(id);
		taskRepository.deleteById(id);

	}

	/**
	 * This method is written to toggle between the Done / Not Done status of a
	 * task. The change in vale will be immediately persisted to the database in the
	 * backend.
	 * 
	 * @param completed This attribute will hold the <code> Boolean </code> value
	 *                  completed
	 * @param taskId    This attribute will hold the taskId of the task whose
	 *                  done/not done status needs to be toggled.
	 * @return
	 */
	public Integer updateCompleted(Boolean completed, Integer taskId) {

		completed = ((completed == true) ? false : true);
		return taskRepository.updateCompleted(completed, taskId);

	}
}
