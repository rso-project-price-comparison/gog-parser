package si.fri.rso.services.dtos.games_by_search_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Price(

	@JsonProperty("discountPercentage")
	int discountPercentage,

	@JsonProperty("isDiscounted")
	boolean isDiscounted,

	@JsonProperty("symbol")
	String symbol,

	@JsonProperty("amount")
	String amount,

	@JsonProperty("bonusStoreCreditAmount")
	String bonusStoreCreditAmount,

	@JsonProperty("isBonusStoreCreditIncluded")
	boolean isBonusStoreCreditIncluded,

	@JsonProperty("isFree")
	boolean isFree,

	@JsonProperty("finalAmount")
	String finalAmount,

	@JsonProperty("discount")
	int discount,

	@JsonProperty("discountDifference")
	String discountDifference,

	@JsonProperty("baseAmount")
	String baseAmount
) {
}