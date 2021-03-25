package com.deloitte.Patyal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deloitte.Patyal.model.Task;
import com.deloitte.Patyal.service.ToDoService;

/**
 * This class will handle all the Http requests related to the To do tasks
 * management page of the application. It handles one GET and three POST
 * requests. It has four methods which are used for the various operations
 * related to the To-do task management.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */

@Controller
@SessionAttributes("name")
public class ToDoController {
	@Autowired
	ToDoService service;

	/**
	 * This method is written the list all the tasks available for a specific user
	 * in the database.
	 * 
	 * @param model It is the holder for model attributes and is primarily designed
	 *              for adding attributes to the model. In this method the tasks
	 *              which are retrieved from the database are added to a model and
	 *              it is displayed in the list-todos.html page.
	 * @return returns the list-todos.html page to the /list-todos Http GET request
	 *         from the browser along with the model attribute with the tasks.
	 */
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {

		String name = (String) model.get("name");
		List<Task> tasks = service.retrieveTodos(name);
		model.put("todos", tasks);

		return "list-todos";
	}

	/**
	 * This method is written to add a new task to a specific users to-do list.
	 * 
	 * @param model       It is the holder for model attributes and is primarily
	 *                    designed for adding attributes to the model. In this
	 *                    method the tasks which are retrieved from the database are
	 *                    added to a model and it is displayed in the
	 *                    list-todos.html page.
	 * @param taskName    It will hold the task name given as input by the user in
	 *                    the list-todos.html page.
	 * @param description It will hold the description of the task given as input by
	 *                    the user in the list-todos.html page.
	 * @param priority    It will hold the priority of the task given as input by
	 *                    the user in the list-todos.html page. It is an
	 *                    <code>Integer</code> value.
	 * @return returns the list-todos.html page to the /list-todos Http GET request
	 *         from the browser along with the model attribute with the tasks.
	 */
	@RequestMapping(value = "/list-todos", method = RequestMethod.POST)
	public String postTodos(ModelMap model, @RequestParam String taskName, @RequestParam String description,
			@RequestParam int priority) {

		String name = (String) model.get("name");
		service.addTodo(taskName, description, priority, name);
		List<Task> tasks = service.retrieveTodos(name);
		model.put("todos", tasks);
		return "list-todos";
	}

	/**
	 * This method will delete a task from the users' list when the taskId is
	 * provided as the input the method.
	 * 
	 * @param model  It is the holder for model attributes and is primarily designed
	 *               for adding attributes to the model. In this method the tasks
	 *               which are retrieved from the database are added to a model and
	 *               it is displayed in the list-todos.html page.
	 * @param taskId It will hold the taskId from the user. The user will enter an
	 *               <code>Integer</code> value in the browser and the corresponding
	 *               task will be deleted from the database.
	 * @return returns the list-todos.html page to the /del-todos Http POST request
	 *         from the browser along with the task to be deleted .
	 */
	@RequestMapping(value = "/del-todos", method = RequestMethod.POST)
	public String deleteTodos(ModelMap model, @RequestParam Integer taskId) {
		
		service.deleteTodo(taskId);
		String name = (String) model.get("name");
		List<Task> tasks = service.retrieveTodos(name);
		model.put("todos", tasks);
		return "list-todos";
	}

	/**
	 * This method is used to mark a task as completed or not completed. When the
	 * toggle button is clicked the checkbox is either selected or unselected and
	 * the completed value in the database is either converted from True to False or
	 * vice versa.
	 * 
	 * @param model     It is the holder for model attributes and is primarily
	 *                  designed for adding attributes to the model. In this method
	 *                  the tasks which are retrieved from the database are added to
	 *                  a model and it is displayed in the list-todos.html page.
	 * @param completed It will hold the Boolean value. Either true or false. If
	 *                  this value is true the checkbox is checked and if this value
	 *                  is false the check box is unchecked.
	 * @param taskId    This attribute will have the corresponding taskId of the
	 *                  task. So when the toggle button is clicked the corresponding
	 *                  true or false value of that particular taskId is persisted
	 *                  in the database.
	 * 
	 * @return returns the list-todos.html page to the /toggle-done Http POST
	 *         request from the browser along with the task for which the value
	 *         needs to be toggled .
	 */
	@RequestMapping(value = "/toggle-done", method = RequestMethod.POST)
	public String toggleDone(ModelMap model, @RequestParam Boolean completed, @RequestParam Integer taskId) {

		System.out.println(completed);
		String name = (String) model.get("name");
		service.updateCompleted(completed, taskId);
		List<Task> tasks = service.retrieveTodos(name);
		model.put("todos", tasks);

		return "list-todos";
	}

}
