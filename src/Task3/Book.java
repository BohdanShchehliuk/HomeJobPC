package Task3;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Book {
    String name;
    String author;
    int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public static void main(String[] args) {

        Book book = new Book("50 відтінків тепла", "Щеглюк", 2021) {

            @Override
            public String toString() {
                return "The best book is  " +
                        "name='" + name + '\'' +
                        ", author='" + author + '\'' +
                        ", year=" + year +
                        '}';
            }
        };
        Book book1 = new Book("Kobzar", "Shevchenko", 1945);
        Book book2 = new Book("Duna", "Herbert", 1985);
        Book book3 = new Book("Mavka", "Ukrainka", 1885);

        Set <Book> set = new HashSet<>();
        set.add(book);
        set.add(book1);
        set.add(book2);
        set.add(book3);
       Function <Book, String> print=x->x.toString()+". Продається у Книгарні Є!!!";

       set.stream().map(x->print.apply(x)).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
