package si.fri.rso;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import si.fri.rso.services.EmbedGogService;
import si.fri.rso.services.GogService;
import si.fri.rso.services.dtos.game_price_response.GamePriceResponse;
import si.fri.rso.services.dtos.games_by_search_response.GamesBySearchResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/")
public class GogResource {

    @RestClient
    EmbedGogService embedGogService;

    @RestClient
    GogService gogService;

    @GET
    @Path("/games/{searchString}")
    public GamesBySearchResponse getGamesBySearch(@PathParam("searchString")String searchString) {
        return embedGogService.getGamesBySearch("game",searchString);
    }

    @GET
    @Path("/prices")
    public GamePriceResponse getGamePrices(@QueryParam("productId") String productId) {
        return gogService.getGamePrice(productId, "SI");
    }

}