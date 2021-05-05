package com.sam.rsocket.client.model;

import java.util.Date;

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
	private Date createdTime;

}
