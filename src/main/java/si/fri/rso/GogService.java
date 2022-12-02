package si.fri.rso;

import si.fri.rso.services.dtos.GameBySearchDto;
import si.fri.rso.services.dtos.GamePriceDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

public interface GogService {
    @GET
    @Path("/games")
    List<GameBySearchDto> getGamesBySearch(@QueryParam("searchString") String searchString);

    @GET
    @Path("/prices")
    List<GamePriceDto> getGamePrices(@QueryParam("ids") List<String> ids);
}
