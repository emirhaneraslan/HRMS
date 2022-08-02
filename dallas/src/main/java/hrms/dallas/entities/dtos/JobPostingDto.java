package hrms.dallas.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.Null;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {

	@ApiModelProperty(hidden = true)
	private int id;
    private int cityId;
    private int employerId;
    private int jobPositionId;
    private String companyName;
    private String cityName;
    private String titleofjob;
    private int minSalary;
    private int maxSalary;
    private String description;
    private Date applicationDeadline;
    private int openPositions;
    private boolean isActive;
    
    
    @ApiModelProperty(hidden = true)
    @Null(message = "must be null")
    private LocalDateTime releaseDateTime = LocalDateTime.now();
    
    
	
	
}
