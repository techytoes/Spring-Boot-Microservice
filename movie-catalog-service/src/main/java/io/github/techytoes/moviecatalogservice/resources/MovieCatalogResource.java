package io.github.techytoes.moviecatalogservice.resources;

import io.github.techytoes.moviecatalogservice.models.CatalogItem;
import io.github.techytoes.moviecatalogservice.models.Movie;
import io.github.techytoes.moviecatalogservice.models.Rating;
import io.github.techytoes.moviecatalogservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {
        UserRatings userRatings = restTemplate.getForObject("http://rating-data-service:8082/ratings/users/" + userID, UserRatings.class);

        return userRatings.getUserRatings().stream().map((rating) -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service:8081/movies/" + rating.getMovieId(), Movie.class);
            assert movie != null;
            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
        }).collect(Collectors.toList());

    }
}
