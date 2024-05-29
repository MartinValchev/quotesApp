package com.quotes.project.QuotesProject.service;

import com.quotes.project.QuotesProject.entity.MovieQuote;
import com.quotes.project.QuotesProject.repository.MovieQuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieQuoteService {

    @Autowired
    private MovieQuotesRepository repository;

    public List<MovieQuote> getAllMovieQuotes() {
        return  repository.findAll();
    }

    public MovieQuote getMovieQuoteByMessage(String message) {
        return repository.findAll().stream().filter(movieQuote -> movieQuote.getMessage().equals(message))
                .findFirst().orElse(null);
    }

    public MovieQuote addNewMovieQuote(MovieQuote movieQuote) {
        return repository.save(movieQuote);
    }

    public MovieQuote removeMovieQuote(String message) {
        MovieQuote movieQuote = getMovieQuoteByMessage(message);
        if (movieQuote != null) {
            repository.deleteById(movieQuote.getId());
        }
        return movieQuote;
    }
}
