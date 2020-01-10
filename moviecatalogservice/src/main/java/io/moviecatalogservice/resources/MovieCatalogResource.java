package io.moviecatalogservice.resources;

import io.moviecatalogservice.models.CatalogItem;
import io.moviecatalogservice.models.Movie;
import io.moviecatalogservice.models.Rating;
import io.moviecatalogservice.models.UserRatings;
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

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //get all movies which has ratings
        List<Rating> ratings = restTemplate.getForObject
                ("http://localhost:8083/ratings/users/"+userId,UserRatings.class).getUserRating();
        return (ratings.stream().map(rating ->
            {
                Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getMovieId(),"test",rating.getRating());
            }).collect(Collectors.toList()));
    }

}
