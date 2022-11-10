package si.fri.rso.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import si.fri.rso.services.dtos.game_price_response.GamePriceResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


@Path("/")
@RegisterRestClient(configKey = "gog-api")
public interface GogService {

    @GET
    @Path("/{productId}/prices")
    GamePriceResponse getGamePrice(@PathParam("productId") String productId, @QueryParam("countryCode") String countryCode);
}