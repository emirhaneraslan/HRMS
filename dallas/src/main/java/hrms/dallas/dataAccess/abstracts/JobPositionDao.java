package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.JobPosition;

//Generic olarak çalışıyor. Arka planda bizim oluşturduğumuz değerlere göre (<JobPosition,Integer>) arka planda spring bir repository class'ı oluşturuyor.
public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{

	JobPosition getById (int id);
	JobPosition getByTitleofjob (String titleofjob);

}
