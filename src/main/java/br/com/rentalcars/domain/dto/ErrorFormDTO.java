package br.com.rentalcars.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorFormDTO {
	
	private String field;
	private String error;

}
