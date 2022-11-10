package si.fri.rso.services.dtos.games_by_search_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WorksOn(

	@JsonProperty("Linux")
	boolean linux,

	@JsonProperty("Windows")
	boolean windows,

	@JsonProperty("Mac")
	boolean mac
) {
}