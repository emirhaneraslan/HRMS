package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.KnownLanguage;

public interface KnownLanguageDao extends JpaRepository<KnownLanguage, Integer>{

	KnownLanguage findKnownLanguageById (int id);
	
}
