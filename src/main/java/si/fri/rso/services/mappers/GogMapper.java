package si.fri.rso.services.mappers;

import si.fri.rso.services.dtos.GameBySearchDto;
import si.fri.rso.services.dtos.GamePriceDto;
import si.fri.rso.services.dtos.StoreEnum;
import si.fri.rso.services.dtos.game_price_response.GamePriceResponse;
import si.fri.rso.services.dtos.games_by_search_response.GamesBySearchResponse;

import java.util.List;

public class GogMapper {

    private GogMapper() {
    }

    public static List<GameBySearchDto> toGameBySearchDto(GamesBySearchResponse response) {

        return response.products().stream()
                .map(p -> new GameBySearchDto(p.title(), String.valueOf(p.id()), StoreEnum.GOG))
                .toList();
    }

    public static GamePriceDto toGamePriceDto(GamePriceResponse response, String gameId) {

        return response.result().prices().stream()
                .filter(p -> p.currency().code().equals("EUR"))
                .map(p -> {
                    Float finalPrice = Float.parseFloat(p.finalPrice().substring(0, p.finalPrice().length() - 4)) / 100;
                    return new GamePriceDto(gameId, finalPrice, p.currency().code(), StoreEnum.GOG);
                })
                .findFirst()
                .orElse(new GamePriceDto(gameId, null, null, StoreEnum.GOG));
    }
}
