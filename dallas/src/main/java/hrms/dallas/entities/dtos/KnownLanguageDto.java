package hrms.dallas.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnownLanguageDto {
	
	private int languageId;
	
	private int languageStageId;

}
