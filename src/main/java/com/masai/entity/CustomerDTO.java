package com.masai.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO {

	@Pattern(regexp="(0/91)?[6-9][0-9]{9}", message = "MobileNumber must be 10 Intergers.")
	private String mobileNumber;
	

	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String passWord;
}
