package com.dnb.jdbcdemo2.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {
	@NotBlank(message = "customer name should not be blank")
	private String CustomerName;
	@NotBlank(message = "Contact number should not be empty")
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String CustomercontactNumber;
	@NotBlank(message = "customeraddress  should not be blank")
	private String Customeraddress;
	@NotBlank(message = "customerUUID  should not be blank")
	private String CustomerUUID;
	@NotBlank(message = "customerPAN  should not be blank")
	private String CustomerPAN;
}
