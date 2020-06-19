package io.github.techytoes.moviecatalogservice.resources;

import io.github.techytoes.moviecatalogservice.models.CatalogItem;
import io.github.techytoes.moviecatalogservice.models.Movie;
import io.github.techytoes.moviecatalogservice.models.Rating;
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
//        return Collections.singletonList(
//                new CatalogItem("Interstellar", "Some Sci-Fi", 5)
//        );

//        RestTemplate restTemplate = new RestTemplate();
        // Get all ratings
        List<Rating> ratings = Arrays.asList(
                new Rating("abc", 4),
                new Rating("ab", 5),
                new Rating("cd", 3)
        );

        return ratings.stream().map((rating) -> {
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            assert movie != null;
            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
        }).collect(Collectors.toList());

        // Fetch movies for these ratings using movieId

        // Combine the 2 data
    }
}
