package si.fri.rso.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import si.fri.rso.services.dtos.games_by_search_response.GamesBySearchResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/")
@RegisterRestClient(configKey = "embed-gog-api")
public interface EmbedGogService {

    @GET
    GamesBySearchResponse getGamesBySearch(@QueryParam("mediaType") String mediaType, @QueryParam("search") String searchString);
}