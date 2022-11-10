package si.fri.rso.services.dtos.games_by_search_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SalesVisibility(

	@JsonProperty("isActive")
	boolean isActive
) {
}