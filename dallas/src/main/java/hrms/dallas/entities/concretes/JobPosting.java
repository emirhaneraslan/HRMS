package hrms.dallas.entities.concretes;

import java.util.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_posting")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_posting_id")
	private int jobPostingId;
	
	@Column(name="position_description")
	private String positionDescription;
	
	@Column(name="min_salary")
	private double minSalary;

	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="active_position_quantity")
	private int activePositionQuantity;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate= LocalDateTime.now();
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	// @ApiModelProperty(hidden = true) //Api'de gizler
	@Column(name="position_active")
	private boolean isActive;
	
	@NotNull
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id")
	private City city;
	
	@NotNull
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@NotNull
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;

}
