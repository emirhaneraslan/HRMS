package hrms.dallas.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Anatasyon: Bir class'ın (metotlara'da uygulanabilir) çalışma anında veya derleme anında onunla ilgili bilgi toplama için kullanılan bir yapı. (.Net = attribute)

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //Burasının bir entity olduğunu belirttik. Bu bizim için jpa altyapısını kullanacak. Sen bir veritabanı nesnesisin demek aynı zamanda.
@Table(name="position_of_job") //Veritabanında hangi tabloya karşılık geldiğini söylüyoruz.
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPosting"})
public class JobPosition {

	@Id //Tablonun id'sinin ne olduğunu belirtmemiz gerekir.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Id'nin nasıl artacağını söylememiz gerekir. Burada 1 1 arttırılacağını söyledik.
	@Column(name="id") //Hangi kolona karşılık gelidiğini yazıyoruz.
	private int id;
	
	@Column(name="titleofjob")
	private String titleofjob;

	@JsonIgnore(value = true)
	@OneToMany(mappedBy = "jobPosition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<JobPosting> jobPostings;
}
