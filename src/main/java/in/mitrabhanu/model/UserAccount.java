package in.mitrabhanu.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String email;
	private Long mob;
	private Character gen;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	private Long ssn;
	private String activeSw = "Y";
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;
}
