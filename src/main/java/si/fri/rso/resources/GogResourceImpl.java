package si.fri.rso.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import si.fri.rso.services.EmbedGogService;
import si.fri.rso.services.GogService;
import si.fri.rso.services.dtos.GameBySearchDto;
import si.fri.rso.services.dtos.GamePriceDto;
import si.fri.rso.services.mappers.GogMapper;

import javax.ws.rs.QueryParam;
import java.util.List;

public class GogResourceImpl implements GogResource {

    @RestClient
    EmbedGogService embedGogService;
    @RestClient
    GogService gogService;

    @Override
    public List<GameBySearchDto> getGamesBySearch(@QueryParam("searchString") String searchString) {
        return GogMapper.toGameBySearchDto(embedGogService.getGamesBySearch("game", searchString));
    }

    @Override
    public  List<GamePriceDto> getGamePrices(@QueryParam("ids") List<String> ids) {

        return ids.stream()
                .map(i -> GogMapper.toGamePriceDto(gogService.getGamePrice(i, "SI"), i))
                .toList();
    }

}