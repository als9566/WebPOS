package com.mysite.webpos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sales {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private Integer salesNumber;
	
	private Integer salesDetailNumber;

    @Column(length = 100)
    private String product;
    
    private Integer ea;

    private String salesDate;
    
    private LocalDateTime createDate;
    
    @ManyToOne
    private Users users;
    
    
}
