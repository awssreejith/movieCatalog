package com.study.moviecatalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.moviecatalog.model.MovieItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class MovieCatalogController {

    @Autowired
    MovieCatalogImpl movieCatalog;

    //End point to retrieve all movies
    @RequestMapping("/movies")
    public List<MovieItem> getMovieDetails() throws Exception {
        return movieCatalog.getAllMovies();
    }
}
