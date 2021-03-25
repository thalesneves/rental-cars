package br.com.rentalcars.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

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
	
	private String name;
	private String year;
	private String brand;
	
}
