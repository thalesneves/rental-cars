package br.com.rentalcars.domain.dto;

import org.springframework.data.domain.Page;

import br.com.rentalcars.domain.entity.Car;
import lombok.Getter;

@Getter
public class CarDTO {
	
	private Long id;
	private String name;
	private String year;
	private String brand;
	
	public CarDTO(Car car) {
		this.id = car.getId();
		this.name = car.getName();
		this.year = car.getYear();
		this.brand = car.getBrand();
	}

	public static Page<CarDTO> converter(Page<Car> cars) {
		return cars.map(CarDTO::new);
	}
	
}
