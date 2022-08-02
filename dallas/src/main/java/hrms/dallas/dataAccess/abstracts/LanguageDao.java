package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.Language;


public interface LanguageDao extends JpaRepository<Language, Integer>{

	Language findLanguageById (int id);
}
