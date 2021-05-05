package com.sam.app.services.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	private BigInteger id;
	private String name;
	private String address;
	private int age;

}
