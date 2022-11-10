package si.fri.rso.services.dtos.game_price_response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AssociatedProduct(

	@JsonProperty("product")
	Product product
) {
}