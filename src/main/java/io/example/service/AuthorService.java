package io.example.service;

import io.example.domain.exception.NotFoundException;
import io.example.domain.model.Author;
import io.example.repository.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author save(Author author) {
        return authorRepo.save(author);
    }

    public List<Author> saveAll(List<Author> authors) {
        return authorRepo.saveAll(authors);
    }

    public Author getAuthor(String id) {
        return authorRepo.findById(id).orElseThrow(() -> new NotFoundException(Author.class, id));
    }

    public List<Author> getAuthors(Iterable<String> ids) {
        List<Author> authors = new ArrayList<>();
        authorRepo.findAllById(ids).forEach(author -> authors.add(author));
        return authors;
    }

}
