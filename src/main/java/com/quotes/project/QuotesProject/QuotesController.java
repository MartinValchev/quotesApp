package com.quotes.project.QuotesProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

    @Autowired
    private QuotesProvider quotesProvider;

    @GetMapping("/project/quotes")
    public String getQuotes() {
        return quotesProvider.getRandomQuote();
    }
}
