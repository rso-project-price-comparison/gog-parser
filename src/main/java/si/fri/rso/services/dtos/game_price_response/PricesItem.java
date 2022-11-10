package si.fri.rso.services.dtos.game_price_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PricesItem(

	@JsonProperty("finalPrice")
	String finalPrice,

	@JsonProperty("currency")
	Currency currency,

	@JsonProperty("basePrice")
	String basePrice,

	@JsonProperty("bonusWalletFunds")
	String bonusWalletFunds
) {
}