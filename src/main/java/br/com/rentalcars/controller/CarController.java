package br.com.rentalcars.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rentalcars.domain.dto.CarDTO;
import br.com.rentalcars.domain.vo.CarVO;
import br.com.rentalcars.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping
	public Page<CarDTO> findAll(@RequestParam(required = false) String brand,
			@PageableDefault(sort = "name", direction = Direction.DESC, page = 0, size = 10) Pageable pagination) {
		return carService.findAll(brand, pagination);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CarDTO> save(@RequestBody @Valid CarVO carVO, UriComponentsBuilder uriBuilder) {
		return carService.save(carVO, uriBuilder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> find(@PathVariable Long id) {
		return carService.find(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CarDTO> edit(@PathVariable Long id, @RequestBody @Valid CarVO carVO) {
		return carService.edit(id, carVO);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return carService.delete(id);
	}
	
}
