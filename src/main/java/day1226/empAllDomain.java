package day1226;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class empAllDomain {
	private String ename , job, officeType;
	private int sal, comm, empno, mgr, deptno;
	private Date hiredate;
}
