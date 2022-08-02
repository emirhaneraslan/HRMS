package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.LanguageStage;

public interface LanguageStageDao extends JpaRepository<LanguageStage, Integer>{

	LanguageStage findLanguageStageById (int id);

}
