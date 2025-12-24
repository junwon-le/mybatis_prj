package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import day1224.EmpDTO;
import day1224.SelectDAO;
import day1224.SelectService;

public class test {

	@Test
	@DisplayName("Select 테스트")
	public void test() {
		SelectService ss = SelectService.getInstance();
		//assertNotNull(ss.scsr(10));
		//assertEquals(ss.scsr(10),"ACCOUNTING");
		//assertNotNull(ss.scmr(10));
		SelectDAO sDAO = SelectDAO.getInstance();
//		EmpDTO eDTO = sDAO.mcsr(7788);
//		System.out.println(eDTO);
		List<EmpDTO> list = sDAO.mcmr(10);
		assertEquals(list.size(), 3);
		
	}

}
