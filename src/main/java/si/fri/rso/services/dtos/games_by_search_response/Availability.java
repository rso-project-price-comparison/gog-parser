package si.fri.rso.services.dtos.games_by_search_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Availability(

	@JsonProperty("isAvailable")
	boolean isAvailable,

	@JsonProperty("isAvailableInAccount")
	boolean isAvailableInAccount
) {
}