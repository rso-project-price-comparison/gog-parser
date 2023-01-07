package si.fri.rso.services.dtos.games_by_search_response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GamesBySearchResponse(

		@JsonProperty("totalResults")
		String totalResults,

		@JsonProperty("totalPages")
		int totalPages,

		@JsonProperty("page")
	int page,

	@JsonProperty("totalGamesFound")
	int totalGamesFound,

	@JsonProperty("products")
	List<ProductsItem> products

) {
}