package si.fri.rso.services.dtos.game_price_response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Result(

	@JsonProperty("prices")
	List<PricesItem> prices
) {
}