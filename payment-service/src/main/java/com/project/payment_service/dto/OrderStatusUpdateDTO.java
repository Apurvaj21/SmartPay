package com.project.payment_service.dto;

import jakarta.validation.constraints.NotNull;

public class OrderStatusUpdateDTO {
	
	  @NotNull
	    private Long orderId;

	    @NotNull
	    private String status;

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
}
