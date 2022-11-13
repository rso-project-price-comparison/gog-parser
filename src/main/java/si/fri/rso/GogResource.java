package si.fri.rso;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import si.fri.rso.services.EmbedGogService;
import si.fri.rso.services.GogService;
import si.fri.rso.services.dtos.GameBySearchDto;
import si.fri.rso.services.dtos.GamePriceDto;
import si.fri.rso.services.mappers.GogMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/gog")
public class GogResource {

    @RestClient
    EmbedGogService embedGogService;
    @RestClient
    GogService gogService;
    @Inject
    GogMapper gogMapper;

    @GET
    @Path("/games")
    public List<GameBySearchDto> getGamesBySearch(@QueryParam("searchString")String searchString) {
        return gogMapper.toGameBySearchDto(embedGogService.getGamesBySearch("game",searchString));
    }

    @GET
    @Path("/prices")
    public  List<GamePriceDto> getGamePrices(@QueryParam("ids") List<String> ids) {

        return ids.stream()
                .map(i -> gogMapper.toGamePriceDto(gogService.getGamePrice(i, "SI"), i))
                .toList();
    }

}