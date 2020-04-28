package org.sid.springmvc.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Patient {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 15, message = "name incorrect - size must be between 5 and 15")
	private String name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private boolean malade;
	@DecimalMin("4")
	private int score;
}
