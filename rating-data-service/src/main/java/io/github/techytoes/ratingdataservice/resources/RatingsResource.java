package io.github.techytoes.ratingdataservice.resources;

import io.github.techytoes.ratingdataservice.models.Rating;
import io.github.techytoes.ratingdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("abc", 4),
                new Rating("ab", 5),
                new Rating("cd", 3)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserRatings(ratings);
        return userRatings;
    }
}
