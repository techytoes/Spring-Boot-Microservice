package io.github.techytoes.moviecatalogservice.models;

import java.util.List;

public class UserRatings {
    private List<Rating> userRatings;

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
