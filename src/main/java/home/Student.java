package home;

import java.util.*;

public class Student {
    private String fullname;
    private String curs;
    private List<Book> list;


    public Student(String fullname, String curs, List<Book> list) {
        this.fullname = fullname;
        this.curs = curs;
        this.list = list;
    }

    public static class Book{
        String name;
        int page;

        public Book(String name, int page) {
            this.name = name;
            this.page = page;
        }

        public String getName() {
            return name;
        }

        public int getPage() {
            return page;
        }
    }

    public String getFullname() {
        return fullname;
    }

    public String getCurs() {
        return curs;
    }

    public List<Book> getList() {
        return list;
    }

     String getArrStr(){
        String str = "";
        for (Book s : list) {
            str +=  " " + s.name;
        }
        return str;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullname='" + fullname + '\'' +
                ", curs='" + curs + '\'' +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) {
        List<Book> listbook = Arrays.asList(new Book("Tolstoi", 1001),
                new Book("Pushkin", 200), new Book("Tyrgenev", 100),
                new Book("Esenin", 200), new Book("Lerontov", 134));
        List<Book> listbook1 = Arrays.asList(new Book("Tolstoi", 44),
                new Book("Simonov", 10000), new Book("Tyrgenev", 20),
                new Book("Esenin", 454), new Book("Lerontov", 232));
        List<Book> listbook2 = Arrays.asList(new Book("Tolstoi", 77),
                new Book("Pushkin", 12), new Book("Prishvin", 56),
                new Book("Esenin", 67), new Book("Lerontov", 121));
        List<Book> listbook3 = Arrays.asList(new Book("Tolstoi", 90),
                new Book("Pushkin", 12), new Book("Tyrgenev", 787),
                new Book("Popov", 234), new Book("Lerontov", 333));

        List<Student> students = Arrays.asList(new Student("SergSimonov", "2 curs", listbook),
                new Student("IvanIvanov", "2 curs", listbook1),
                new Student("PetrPetrov", "3 curs", listbook2),
                new Student("VasyVasiliev", "4 curs", listbook3));

        students.stream()//.peek(integer -> System.out.println())
                .sorted()
                .forEach(integer -> System.out.println(integer + integer.getFullname() + ":" + integer.getArrStr()));
    }
}
