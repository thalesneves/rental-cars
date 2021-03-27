package br.com.rentalcars.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="car")
public class Car extends AbstractEntity {
	
	@NotNull @NotEmpty
	private String name;
	
	@NotNull @NotEmpty
	private String year;
	
	@NotNull @NotEmpty
	private String brand;
	
}
