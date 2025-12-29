package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import day1224.EmpDTO;
import day1224.SelectDAO;
import day1224.SelectService;
import day1226.EmpDomain;
import day1226.SelectDAO2;
import day1226.ZipCodeDomain;
import day1229.SelectDAO3;
import day1229.SelectService3;
import kr.co.sist.car.carSearchDAO;
import kr.co.sist.car.carSearchService;

public class test {

	@Test
	@DisplayName("Select 테스트")
	public void test() {
//		SelectService ss = SelectService.getInstance();
		//assertNotNull(ss.scsr(10));
		//assertEquals(ss.scsr(10),"ACCOUNTING");
		//assertNotNull(ss.scmr(10));
//		SelectDAO sDAO = SelectDAO.getInstance();
//		EmpDTO eDTO = sDAO.mcsr(7788);
//		System.out.println(eDTO);
//		List<EmpDTO> list = sDAO.mcmr(10);
//		assertEquals(list.size(), 3);
		
//		day1226.EmpDTO eDTO = new day1226.EmpDTO();
//		eDTO.setEmpno(7521);
//		eDTO.setDeptno(30);
//		
//		SelectDAO2 sDAO = SelectDAO2.getInstance();
		SelectDAO3 sDAO3 = SelectDAO3.getInstance();
		SelectService3 ss3 = SelectService3.getInstance();
//		EmpDomain ed = sDAO.useDomain(eDTO);
		try {
//			assertNotNull(sDAO.useLike("대치동"));
//			assertNotNull(sDAO.greaterThan(3000));
//			assertNotNull(sDAO.subquery());
//			assertNotNull(sDAO.union());
			assertNotNull(ss3.dynamicIf(10));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	@DisplayName("Select 테스트")
	@Disabled
	public void cartest() {
		carSearchService css = carSearchService.getInstance();
		carSearchDAO cDAO = carSearchDAO.getInstance();
		try {
			assertNotNull(cDAO.selectModel("현대"));
			System.out.println(css.searchModel("기아"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
