package com.example.multipledb.primary;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="primeryentity")
public class PrimaryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
