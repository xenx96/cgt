package com.cgt.cgt_prj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class CgtPrjApplicationTests {
	@Test
	public void testStart(){
		Date now = new Date();
		System.out.println("현재 시간은 "+now.toString()+"---------------------------Test를 시작합니다.-------------------------");
	}


}
