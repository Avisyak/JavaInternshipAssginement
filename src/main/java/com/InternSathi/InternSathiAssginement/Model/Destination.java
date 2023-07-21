package com.InternSathi.InternSathiAssginement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="destination_table")
public class Destination {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private String photo;
	private String details;
	

}
