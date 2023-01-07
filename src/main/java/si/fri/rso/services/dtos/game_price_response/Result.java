package si.fri.rso.services.dtos.game_price_response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Result(

        @JsonProperty("prices")
        List<PricesItem> prices
) {
}