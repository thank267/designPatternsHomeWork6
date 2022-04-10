package thank267.commons.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Duration {

	@Getter
	@Setter
	private Integer value;

	@Getter
	@Setter
	private DurationEnum unit = DurationEnum.День;

}
