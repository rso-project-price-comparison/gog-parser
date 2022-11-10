package si.fri.rso.services.dtos.game_price_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GamePriceResponse(

	@JsonProperty("_links")
	AssociatedProduct product,

	@JsonProperty("_embedded")
	Result result
) {
}