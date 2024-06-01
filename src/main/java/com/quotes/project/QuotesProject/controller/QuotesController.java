package com.quotes.project.QuotesProject.controller;

import com.quotes.project.QuotesProject.entity.MovieQuote;
import com.quotes.project.QuotesProject.repository.QuotesProvider;
import com.quotes.project.QuotesProject.service.MovieQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuotesController {

    @Autowired
    private QuotesProvider quotesProvider;

    @Autowired
    private MovieQuoteService movieQuoteService;

    @GetMapping("/project/quotes")
    public String getAllMovieQuotes() {
        return movieQuoteService.toAllMovieQuotesString();
    }

    @GetMapping("/project/quotes/byMessage")
    public String getMovieQuoteByMessage(@RequestParam String message) {
        return movieQuoteService.getMovieQuoteByMessage(message).toString();
    }

    @PostMapping("/project/quotes")
    public String addMovieQuote(@RequestBody MovieQuote movieQuote) {
        MovieQuote persistedEntity = movieQuoteService.addNewMovieQuote(movieQuote);
        return persistedEntity.getId().toString();
    }
}
