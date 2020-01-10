package io.ratingsdataservice.resources;

import io.ratingsdataservice.models.Rating;
import io.ratingsdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getUserRatings(){
        List<Rating> ratings = Arrays.asList(
                new Rating("1",1),
                new Rating("2",2)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserRating(ratings);
        return userRatings;
    }
}
