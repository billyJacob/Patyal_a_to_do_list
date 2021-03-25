package com.deloitte.Patyal.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.Patyal.repository.UserRepository;
import com.deloitte.Patyal.service.LoginService;
import com.deloitte.Patyal.service.ToDoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;
	
	@MockBean
	private UserRepository userRepository;
	
	//@Test
	//public void validateUserTest() {
	//	when(userRepository.findPassword(new String("admin"))).thenReturn("admin");
		//assertEquals(true, loginService.validateUser(new String("admin"), new String("admin")) );
	//}

}
