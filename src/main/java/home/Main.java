package home;

import java.util.*;

public class Main {
    static class Book {
        String title;
        int pages;
        int year;

        public Book(String title, int pages, int year) {
            this.title = title;
            this.pages = pages;
            this.year = year;
        }

        public int getPages() {
            return pages;
        }

        public int getYear() {
            return year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book)) return false;
            Book book = (Book) o;
            return pages == book.pages &&
                    year == book.year &&
                    Objects.equals(title, book.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, pages, year);
        }

        @Override
        public String toString() {
            return String.format("%s (%d pages, %d)", title, pages, year);
        }
    }

    static class Student {
        String name;
        List<Book> books;

        public Student(String name, List<Book> books) {
            this.name = name;
            this.books = books;
        }

        public List<Book> getBooks() {
            return books;
        }

        @Override
        public String toString() {
            return name + ": " + books;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList(
                        new Book("Book A1", 100, 1999),
                        new Book("Book A2", 150, 2005),
                        new Book("Book A3", 200, 2010),
                        new Book("Book A4", 120, 2001),
                        new Book("Book A5", 80, 2015))),
                new Student("Bob", Arrays.asList(
                        new Book("Book B1", 110, 2002),
                        new Book("Book B2", 90, 2000),
                        new Book("Book B3", 300, 1998),
                        new Book("Book B4", 400, 2003),
                        new Book("Book B5", 150, 2007))),
                new Student("Charlie", Arrays.asList(
                        new Book("Book C1", 250, 2004),
                        new Book("Book C2", 350, 2011),
                        new Book("Book C3", 120, 2008),
                        new Book("Book C4", 220, 2006),
                        new Book("Book C5", 300, 2013)))
        );

        students.stream()
                .peek(System.out::println) // выводим каждого студента
                .map(Student::getBooks)    // получаем список книг студента
                .flatMap(Collection::stream) // превращаем в поток книг
                .sorted(Comparator.comparingInt(Book::getPages)) // сортируем по страницам
                .distinct() // уникальные книги
                .filter(b -> b.getYear() > 2000) // книги после 2000
                .limit(3) // первые 3 книги
                .map(Book::getYear) // получаем год выпуска
                .findFirst() // Optional<Integer>
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга, соответствующая условиям, не найдена")
                );
    }
}
