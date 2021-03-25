package br.com.rentalcars.domain.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rentalcars.domain.entity.Car;
import br.com.rentalcars.repository.CarRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVO {
	
	@NotNull @NotEmpty
	private String name;
	
	@NotNull @NotEmpty
	private String year;
	
	@NotNull @NotEmpty
	private String brand;
	
	public Car edit(Long id, CarRepository carRepository) {
		Car car = carRepository.getOne(id);
		car.setName(this.name);
		car.setYear(this.year);
		car.setBrand(this.brand);
		
		return car;
	}
	
}
