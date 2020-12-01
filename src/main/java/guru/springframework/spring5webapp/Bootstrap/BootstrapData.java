package guru.springframework.spring5webapp.Bootstrap;

import models.Author;
import models.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repositories.AuthorRepository;
import repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book neJA =new Book("newja","1223344");
        eric.getBooks().add(neJA);
        neJA.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(neJA);

        Author rod = new Author("Rod","Johnson");
        Book neJAva =new Book("newjava","5623344");
        rod.getBooks().add(neJA);
        neJAva.getAuthors().add(eric);

        authorRepository.save(rod);
        bookRepository.save(neJAva);

        System.out.println("Started in bootstrap");
        System.out.println("total books"+bookRepository.count());




    }
}
