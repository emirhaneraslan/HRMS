package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City getByCityId (Integer cityId);
	City getByCityName (String cityName);
}
