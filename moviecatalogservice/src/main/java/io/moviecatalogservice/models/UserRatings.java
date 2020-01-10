package io.moviecatalogservice.models;

import java.util.List;

public class UserRatings {

    private List<Rating> userRating;

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

}
