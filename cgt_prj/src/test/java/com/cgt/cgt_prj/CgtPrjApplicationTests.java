package com.cgt.cgt_prj;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.AuthService;
import io.jsonwebtoken.Jwts;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CgtPrjApplicationTests {

	@Test
	public void testJWT(){
		AuthService authService = new AuthService();
		JSONObject form = new JSONObject();
		//form.put("id","admin");
		//form.put("EA","admin@naver.com");
		String token = authService.jsonWebTokenMake(form);

		System.out.println(Jwts.parser()
				.setSigningKey("secret")
				.parseClaimsJws(token)
				.getBody());
	}
	@Test
	public void testLogin(){
		AuthService authService = new AuthService();
		UserDTO userDTO = new UserDTO();
		String loginTest = authService.userLogin(userDTO);
		System.out.println(loginTest);

	}

}
