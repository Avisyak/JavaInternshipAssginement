package com.InternSathi.InternSathiAssginement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="booking_table")
public class Booking {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String date;
	private String destination;
	private String request;

}
