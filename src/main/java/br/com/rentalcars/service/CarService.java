package br.com.rentalcars.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rentalcars.domain.dto.CarDTO;
import br.com.rentalcars.domain.entity.Car;
import br.com.rentalcars.domain.vo.CarVO;
import br.com.rentalcars.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public Page<CarDTO> findAll(String brand, Pageable pagination) {
		if (brand == null) {
			Page<Car> cars = carRepository.findAll(pagination);
			return CarDTO.converter(cars);
		} else {
			Page<Car> cars = carRepository.findByBrand(brand, pagination);
			return CarDTO.converter(cars);
		}
	}
	
	public ResponseEntity<CarDTO> save(CarVO carVO, UriComponentsBuilder uriBuilder) {
		String name = carVO.getName();
		String year = carVO.getYear();
		String brand = carVO.getBrand();
		
		Car car = new Car(name, year, brand);
		carRepository.save(car);
		
		URI uri = uriBuilder.path("/car/{id}").buildAndExpand(car.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarDTO(car));
	}
	
	public ResponseEntity<CarDTO> find(Long id) {
		Optional<Car> car = carRepository.findById(id);
		
		if (car.isPresent()) {
			return ResponseEntity.ok(new CarDTO(car.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<CarDTO> edit(Long id, CarVO carVO) {
		Optional<Car> carOptional = carRepository.findById(id);
		
		if (carOptional.isPresent()) {
			Car car = carVO.edit(id, carRepository);
			
			return ResponseEntity.ok(new CarDTO(car));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> delete(Long id) {
		Optional<Car> optional = carRepository.findById(id);
		
		if (optional.isPresent()) {
			carRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
