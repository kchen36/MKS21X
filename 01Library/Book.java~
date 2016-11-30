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
	return title + ", "+author +", "+ISBN
    }
}
abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String a,String t, String i, String c){
	super(String a,String t, String i);
	callNumber = c;
    }
    public String getCall(){
	return callNumber;
    }
    public void setCall(String s){
	callNumber = s;
    }
    abstract void checkout(String patron, String due){
    }
    abstract void returned(){
    }
    abstract String circulationStatus(){
    }
    public int compareTo(){
    }
    public string toString(){
	return super.toString +circulation
    }
}
