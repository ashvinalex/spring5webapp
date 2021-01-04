package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Designs","12455");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        System.out.println("No of books"+bookRepository.count());

        Publisher pub1 =new Publisher();
        pub1.setName("sfg publishing");
        pub1.setCity("St peters");
        pub1.setCity("Fl");
        publisherRepository.save(pub1);
        ddd.setPublisher(pub1);
        pub1.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(pub1);


        Author rodd = new Author("Rodd","Evans");
        Book j2= new Book("j2ee","12455888");
        eric.getBooks().add(j2);
        ddd.getAuthors().add(rodd);
        j2.setPublisher(pub1);
        pub1.getBooks().add(j2);
        authorRepository.save(rodd);
        bookRepository.save(j2);
        publisherRepository.save(pub1);
        System.out.println("Started in bootstrap");

        System.out.println(publisherRepository.count());

        System.out.println("publisher book size:"+pub1.getBooks().size());
    }
}
