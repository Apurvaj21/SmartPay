package com.project.order_service.dto;
import jakarta.validation.constraints.*;

public class OrderRequestDTO {
	 @NotBlank(message = "Product name is required")
	    private String productName;

	    @NotNull(message = "Amount is required")
	    @Positive(message = "Amount must be greater than 0")
	    private Double amount;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
