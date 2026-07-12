package com.project.payment_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PaymentRequestDTO {
	
	 @NotNull(message = "Order ID is required")
	    private Long orderId;

	    @NotNull(message = "Amount is required")
	    @Positive(message = "Amount must be positive")
	    private Double amount;

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}
}
