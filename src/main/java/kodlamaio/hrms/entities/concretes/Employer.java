package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_adress")
	private String webAdress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@JsonIgnore
	@Column(name = "is_activated")
	private boolean isActivated;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer") 
	private List<JobAdvertisement>  advertisements;
}
