package si.fri.rso.services.dtos.games_by_search_response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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