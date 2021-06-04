package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisement")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cities")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="employers_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_positions_id")
	private JobPosition jobPosition;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="open_positions")
	private int openPosition;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive=false;
	
	@Column(name="created_date")
	private Date createdDate;
	
	

}
