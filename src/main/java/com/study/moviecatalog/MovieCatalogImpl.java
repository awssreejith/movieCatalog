package com.study.moviecatalog;

import com.study.moviecatalog.model.MovieDetail;
import com.study.moviecatalog.model.MovieItem;
import com.study.moviecatalog.model.MovieReviewDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class MovieCatalogImpl {

    @Autowired
    RestTemplate restTemplate;

    private String movieInfoServiceKey="movie-info-service";
    private String movieReviewServiceKey="movie-review-service";

    public List<MovieItem> getAllMovies() throws Exception {

        String uriForMovieInfo = String.format("http://%s/details", movieInfoServiceKey);
        String uriForReview = String.format("http://%s/reviews", movieReviewServiceKey);
        List<MovieDetail> movies = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(uriForMovieInfo, MovieDetail[].class)));
        List<MovieReviewDetail> reviews = Arrays.asList((Objects.requireNonNull(restTemplate.getForObject(uriForReview, MovieReviewDetail[].class))));

        List<MovieItem> retList = new ArrayList<>();
        for (MovieDetail movie : movies) {
            MovieItem movieItem = new MovieItem();
            movieItem.setName(movie.getName());
            movieItem.setDescription(movie.getDescription());
            movieItem.setRating(0.0f);

            for (MovieReviewDetail rev : reviews) {
                if (rev.getId().equals(movie.getId())) {
                    movieItem.setRating(rev.getReview());
                    break;
                }
            }
            retList.add(movieItem);
        }

        return retList;
    }

}



