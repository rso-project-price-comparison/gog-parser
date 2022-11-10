package si.fri.rso.services.dtos.games_by_search_response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductsItem(

	@JsonProperty("buyable")
	boolean buyable,

	@JsonProperty("isDiscounted")
	boolean isDiscounted,

	@JsonProperty("supportedOperatingSystems")
	List<String> supportedOperatingSystems,

	@JsonProperty("salesVisibility")
	SalesVisibility salesVisibility,

	@JsonProperty("rating")
	int rating,

	@JsonProperty("availability")
	Availability availability,

	@JsonProperty("title")
	String title,

	@JsonProperty("type")
	int type,

	@JsonProperty("ageLimit")
	int ageLimit,

	@JsonProperty("isTBA")
	boolean isTBA,

	@JsonProperty("isPriceVisible")
	boolean isPriceVisible,

	@JsonProperty("genres")
	List<String> genres,

	@JsonProperty("price")
	Price price,

	@JsonProperty("isInDevelopment")
	boolean isInDevelopment,

	@JsonProperty("id")
	int id,

	@JsonProperty("gallery")
	List<String> gallery,

	@JsonProperty("image")
	String image,

	@JsonProperty("releaseDate")
	int releaseDate,

	@JsonProperty("worksOn")
	WorksOn worksOn,

	@JsonProperty("url")
	String url,

	@JsonProperty("globalReleaseDate")
	int globalReleaseDate,

	@JsonProperty("isComingSoon")
	boolean isComingSoon,

	@JsonProperty("publisher")
	String publisher,

	@JsonProperty("developer")
	String developer,

	@JsonProperty("originalCategory")
	String originalCategory,

	@JsonProperty("category")
	String category
) {
}