package br.com.rentalcars.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rentalcars.domain.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	Car findByName(String name);
	
	Page<Car> findByBrand(String brand, Pageable paginacao);

}
