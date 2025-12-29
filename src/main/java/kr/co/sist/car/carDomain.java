package kr.co.sist.car;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class carDomain {
	private String model, car_year, price, cc, car_img, car_option;
	private Date input_date;
}
