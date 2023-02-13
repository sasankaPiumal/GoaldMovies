package com.saspi.Movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> data = movieService.allMovies();
        return new ResponseEntity<List<Movie>>(data, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable(value = "id")ObjectId id){
        Optional<Movie> data = movieService.OneMovie(id);
        return new ResponseEntity<Optional<Movie>>(data, HttpStatus.OK);

    }

}
