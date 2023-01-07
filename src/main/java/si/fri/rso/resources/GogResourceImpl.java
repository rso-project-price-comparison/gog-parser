package si.fri.rso.resources;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.faulttolerance.Timeout;
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
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class GogResourceImpl implements GogResource {

    @RestClient
    EmbedGogService embedGogService;
    @RestClient
    GogService gogService;

    private AtomicLong counter = new AtomicLong(0);
    private Random random = new Random();

    private static final Marker ENTRY_MARKER = MarkerFactory.getMarker("ENTRY");
    private static final Marker OUT_MARKER = MarkerFactory.getMarker("OUT");

    Logger log = LoggerFactory.getLogger(GogResourceImpl.class);

    @Override
    @Timeout(250)
    public List<GameBySearchDto> getGamesBySearch(@QueryParam("searchString") String searchString) {
        log.info(ENTRY_MARKER, "Calling gog service: get games by search.");

        final Long invocationNumber = counter.getAndIncrement();
        log.warn(String.format("Called SteamResourceImpl::getGamesBySearchString invocation #%d", invocationNumber));

        randomDelay();

        List<GameBySearchDto> result = GogMapper.toGameBySearchDto(embedGogService.getGamesBySearch("game", searchString));

        log.info(OUT_MARKER, "Calling gog service: games by search fetched.");
        return result;
    }

    @Override
    public List<GameBySearchDto> getGamesBySearchStringFallback(String searchString) {
        log.info(ENTRY_MARKER, "Calling gog service: get games by search.");

        List<GameBySearchDto> result = GogMapper.toGameBySearchDto(embedGogService.getGamesBySearch("game", searchString));

        log.info(OUT_MARKER, "Calling gog service: games by search fetched.");
        return result;
    }


    private void randomDelay() {
        try {
            Thread.sleep(random.nextInt(350));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Blocking
    @Override
    public Uni<List<GamePriceDto>> getGamePrices(@QueryParam("ids") List<String> ids) {

        log.info(ENTRY_MARKER, "Calling gog service: get game prices.");

        List<GamePriceDto> result = ids.stream()
                .map(i -> GogMapper.toGamePriceDto(gogService.getGamePrice(i, "SI"), i))
                .toList();

        log.info(OUT_MARKER, "Calling gog service: game prices fetched.");

        return Uni.createFrom().item(result);
    }

}