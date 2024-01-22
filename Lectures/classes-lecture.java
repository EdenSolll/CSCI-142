package classes;

public class Book {

  public static final int Max_PAGES = 4000;

  private String title;

  private int pages;

  private boolean hardcover;

  private int currentPage;

  public Book(String title, int, pages, boolean hardcover){

    title=title;

    pages=pages;

    hardcover= hardcover;

    currentPage = 0;
  }
}
