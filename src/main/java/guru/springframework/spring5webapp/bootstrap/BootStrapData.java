package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Author eric = new Author("Eric", "Novel");
        Book newBook = new Book("New Desighn", "123123123");
        eric.getBooks().add(newBook);
        newBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(newBook);

        Author rod = new Author("Rod", "Williams");
        Book newBook2 = new Book("BOOOk", "789343450");
        rod.getBooks().add(newBook2);
        newBook2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(newBook2);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());

        Publisher publisher = new Publisher("Address line", "New York", "New York", "1234");
        publisherRepository.save(publisher);
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
