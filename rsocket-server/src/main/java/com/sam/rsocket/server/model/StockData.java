package com.sam.rsocket.server.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockData {
	
	private String user;
	private String code;
	private Double price;
	private Instant createdTime;

}
