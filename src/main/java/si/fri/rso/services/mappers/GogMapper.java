package si.fri.rso.services.mappers;

import si.fri.rso.services.dtos.GameBySearchDto;
import si.fri.rso.services.dtos.GamePriceDto;
import si.fri.rso.services.dtos.game_price_response.GamePriceResponse;
import si.fri.rso.services.dtos.games_by_search_response.GamesBySearchResponse;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class GogMapper {

    public List<GameBySearchDto> toGameBySearchDto(GamesBySearchResponse response) {

        return response.products().stream()
                .map(p -> new GameBySearchDto(p.title(), String.valueOf(p.id())))
                .toList();
    }

    public GamePriceDto toGamePriceDto(GamePriceResponse response, String gameId) {

        return response.result().prices().stream()
                .filter( p -> p.currency().code().equals("EUR"))
                .map(p ->{
                    Float finalPrice = Float.parseFloat(p.finalPrice().substring(0, p.finalPrice().length() - 4))/100;
                    return new GamePriceDto(gameId, finalPrice, p.currency().code());
                })
                .findFirst()
                .orElse(new GamePriceDto(gameId, null, null));
    }
}
