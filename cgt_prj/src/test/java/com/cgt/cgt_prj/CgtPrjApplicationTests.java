package com.cgt.cgt_prj;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.LoginService;
import com.cgt.cgt_prj.service.UserService;
import io.jsonwebtoken.Jwts;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CgtPrjApplicationTests {
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "loginService")
	private LoginService loginService;

	@Test
	public void testJWT(){
		JSONObject form = new JSONObject();
		//form.put("id","admin");
		//form.put("EA","admin@naver.com");
		String token = loginService.jsonWebTokenMake(form);

		System.out.println(Jwts.parser()
				.setSigningKey("secret")
				.parseClaimsJws(token)
				.getBody());
	}
	@Test
	public void testLogin(){


		UserDTO user2 = new UserDTO();
		user2.set_id("admin1234");
		user2.setPW("asdf1234");
		System.out.println("test1");
		String loginTest2 = loginService.userLogin(user2);
		System.out.println(loginTest2);

		UserDTO user3 = new UserDTO();
		user3.set_id("xenx96");
		user2.setPW("ydsm1738");
		System.out.println("test2");
		String loginTest3 = loginService.userLogin(user3);
		System.out.println(loginTest3);




	}

}
