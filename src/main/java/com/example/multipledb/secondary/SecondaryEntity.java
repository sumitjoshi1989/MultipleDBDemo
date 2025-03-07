package com.example.multipledb.secondary;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="secondaryentity")
public class SecondaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="description")
    private String description;
    // getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
