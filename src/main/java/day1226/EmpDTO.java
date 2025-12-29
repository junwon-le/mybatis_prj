package day1226;
/**
 *	insert에 추가되는 값 , update의 변경값 ,, delete에서 where절에 사용하는 값, select where절에 사용하는 값
 *  <jsp:useBean> : 기본 생성자를 사용하여 객체화를 하고
 *  <jsp:setProperty> : setter method를 통해 입력값이 저장
 *  Mybatis에서는 parameterType = "empDTO" 를 입력 받아서 #{getter명}으로 사용. 
 */
public class EmpDTO {
	private int deptno, empno;

	public EmpDTO() {
		System.out.println("<jsp:useBean에 의해서 객체화");
	}

	public int getDeptno() {
		System.out.println("MyBatis에서 #{deptno} 로 사용");
		return deptno;
	}

	public void setDeptno(int depno) {
		System.out.println("<jsp:setproperty에서 setDeptno를 사용");
		this.deptno = depno;
	}

	public int getEmpno() {
		System.out.println("MyBatis에서 #{empno} 로 사용");
		return empno;
	}

	public void setEmpno(int empno) {
		System.out.println("<jsp:setproperty에서 setEmpno 사용");
		this.empno = empno;
	}
	
}
