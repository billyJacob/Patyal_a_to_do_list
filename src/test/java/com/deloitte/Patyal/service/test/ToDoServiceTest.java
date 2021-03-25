package com.deloitte.Patyal.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.Patyal.model.Task;
import com.deloitte.Patyal.repository.TaskRepository;
import com.deloitte.Patyal.repository.UserRepository;
import com.deloitte.Patyal.service.LoginService;
import com.deloitte.Patyal.service.ToDoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {
	
	@Autowired
	private ToDoService toDoService;
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private TaskRepository taskRepository;
	
	//@Test
	//public void retrieveTodosTest() {
	//	when(userRepository.findUserId(new String("admin"))).thenReturn(1);
	//	when(taskRepository.findTasks(1)).thenReturn(Stream.of(new Task (1,"breakfast","breakfast befor 9 AM", new Date(),1,false,1) ).collect(Collectors.toList()));
	 //   assertEquals(1, toDoService.retrieveTodos(new String("admin")).size());
	//}
	
// unable to mock the new Task because the date created with the test and the date created 
// within the service method is vaying.
	
//	@Test
//	public void addTodoTest() {
//	Task task = new Task (1,"breakfast","breakfast before 9 AM", new Date(),1,false,1);
//	when(taskRepository.save(task)).thenReturn(task);
	
//	when(userRepository.findUserId(new String("admin"))).thenReturn(1);
//	Task t = toDoService.addTodo(new String("breakfast"),new String("breakfast before 9 AM"), 1 ,new String("admin"));
//	assertEquals(task, t);
//	}
	
	//@Test
	//public void updateCompletedTest() {
		//Task task = new Task (1,"breakfast","breakfast before 9 AM", new Date(),1,true,1);
		//when(taskRepository.updateCompleted(true,1)).thenReturn(1);
		//Integer check = 1;
		//Integer num = toDoService.updateCompleted(false,1);
	   // assertEquals(check, num );
	//}
	
}
