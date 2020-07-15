package com.jeomo.mem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jeomo.mem.MemberApplication;
import com.jeomo.mem.mapper.MemberMapper;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemberApplication.class)
public class AppTest 
{
	@Autowired
	MemberMapper memberMapper;
	
    @Test
    public void testGetMaxMemberCode()
    {
    	String maxMemberCode = memberMapper.queryMaxMemberCode("123123");
    	System.out.println(maxMemberCode);
        
    }
}
