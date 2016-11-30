public class Book{
    private String author;
    private String title;
    private String ISBN;
    public Book(){
    }
    public Book(String a,String t, String i){
    author = a;
    title = t;
    ISBN = i;
    }
    public String getAuthor(){
    return author;
    }
    public String getTitle(){
    return title;
    }
    public String getISBN(){
    return ISBN;
    }
    public void setAuthor(String s){
    author = s;
    }
    public void setTitle(String s){
    title = s;
    }
    public void setISBN(String s){
    ISBN = s;
    }
    public String toString(){
    return title + ", "+author +", "+ISBN;
    }
}
abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String a,String t, String i, String c){
    super(a,t,i);
    callNumber = c;
    }
    public String getCall(){
    return callNumber;
    }
    public void setCall(String s){
    callNumber = s;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public int compareTo(LibraryBook l){
    String n = callNumber;
    String n2 = l.getCall();
    if (n.equals(n2))return 0;
    else if (n > n2)return 1;
    else return -1;
    }
    public String toString(){
    return super.toString()+ ", " +circulationStatus() + ", " + callNumber;
    }
}
public class ReferenceBook extends LibraryBook{
    private String  collection;
    public ReferenceBook(String a,String t, String i, String c, String co){
    super(a,t,i,c);
    collection = co;
    }
    public String getCollection(){
    return collection;
    }
    public void setCollection(String c){
    collection = c;
    }
    public void checkout(){
    System.out.println( "cannot check out a reference book");
    }
    public void returned(){
    System.out.println("reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
    return"non-circulating reference book";
    }
    public String toString(){
    return super.toString()+", "+ collection;
    }
}
