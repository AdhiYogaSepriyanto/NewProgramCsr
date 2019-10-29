package com.example.ProgramCsr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tblprogramcsr {
    private Long id;
    private String name;
    private String category;
    private String location;
    private String pindate;
 
    protected Tblprogramcsr() {
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPindate() {
		return pindate;
	}

	public void setPindate(String pindate) {
		this.pindate = pindate;
	}

	public void setId(Long id) {
		this.id = id;
	}
     
    // other getters and setters are hidden for brevity
}
