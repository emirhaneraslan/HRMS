package hrms.dallas.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name="employee")
@PrimaryKeyJoinColumn(name="employee_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","employee"})
public class Employee extends User{
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	
	
}
