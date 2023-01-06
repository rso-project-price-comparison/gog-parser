package si.fri.rso.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
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

    private static final Marker ENTRY_MARKER = MarkerFactory.getMarker("ENTRY");
    private static final Marker OUT_MARKER = MarkerFactory.getMarker("OUT");
    Logger log = LoggerFactory.getLogger(GogResourceImpl.class);

    @Override
    public List<GameBySearchDto> getGamesBySearch(@QueryParam("searchString") String searchString) {
        log.info(ENTRY_MARKER, "Calling gog service: get games by search.");

        List<GameBySearchDto> result = GogMapper.toGameBySearchDto(embedGogService.getGamesBySearch("game", searchString));

        log.info(OUT_MARKER, "Calling gog service: games by search fetched.");
        return result;
    }

    @Override
    public  List<GamePriceDto> getGamePrices(@QueryParam("ids") List<String> ids) {

        log.info(ENTRY_MARKER, "Calling gog service: get game prices.");

        List<GamePriceDto> result = ids.stream()
                .map(i -> GogMapper.toGamePriceDto(gogService.getGamePrice(i, "SI"), i))
                .toList();

        log.info(OUT_MARKER, "Calling gog service: game prices fetched.");
        return result;
    }

}