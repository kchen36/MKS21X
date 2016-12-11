import java.util.*;
public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() == 5 && zip.matches("[0-9]+")){
	    _zip = zip;
	    _checkDigit = checkSum() % 10;
	}
	else{
	    throw new RuntimeException();
	}
    }
    
    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode copy = new Barcode(_zip);
	return copy;
    }

    
    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for(int x = 0; x < _zip.length();x++){
	    sum += Integer.parseInt(_zip.charAt(x) +"");
	}
	return sum;
    }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String s = "";
	s+= _zip + _checkDigit;
	s+="   |";
	toCode(_zip);
	s+= "|";
	return s;
    }
    private static String bar(char num){
	if( num == '0') return "||:::";
	if( num == '1') return ":::||";
	if( num == '2') return "::|:|";
	if( num == '3') return "::||:";
	if( num == '4') return ":|::|";
	if( num == '5') return ":|:|:";
	if( num == '6') return ":||::";
	if( num == '7') return "|:::|";
	if( num == '8') return "|::|:";
	if( num == '9') return "|:|::";
	else return "";
    }
    public String getZip(){
	return _zip + _checkDigit;
    }

// postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return (other.getZip()).compareTo(_zip +_checkDigit);
	
    }
    public static String toCode(String zip){
	if (zip.length() == 5 && zip.matches("[0-9]+")){
	    Barcode bar = new Barcode(zip);
	    zip = bar.getZip();
	    String s = "";
	    char[] num  = new char[6];
	    for(int x = 0;x < zip.length(); x ++){
		num[x] = zip.charAt(x);
		s += bar(num[x]);
	    }
	    return s;
	}
	else throw new IllegalArgumentException();
    }
    public static boolean check(String s){
	for(int x = 0; x <s.length();x++){
	    if(s.charAt(x) != ':' || s.charAt(x) != '|') return false;
	}
	return true;
    }
    public static String[] bars ={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    public static boolean check2(String s){
	for(int x = 1; x <s.length()-1;x+=5){
	    if(!Arrays.asList(bars).contains(s.substring(x,x+5))) return false;
	}
	return true;
    }
    public static int sumOf(String s){
	int val = 0;
	for(int x = 0; x <s.length();x++){
	    val += Integer.parseInt(s.charAt(x) +"");
	}
	return val;
    }
    public static String toZip(String Barcode){
	if (Barcode.length()!=32){
	    throw new IllegalArgumentException("length of barcode is not 32");
	}
	else if(Barcode.charAt(0) !='|' || Barcode.charAt(32) != '|'){
	    throw new IllegalArgumentException("barcode does not begin or end with'|'");
	}
	else if(!check(Barcode)){
	    throw new IllegalArgumentException("barcode does not consist of only ':' or '|'");
	}
	else if(!check2(Barcode)){
	    throw new IllegalArgumentException("not valid ints");
	}
	else{
	    String s = "";
	    int x;
	    for(x = 1; x < Barcode.length()-6;x+=5){
		s+=Arrays.asList(bars).indexOf(Barcode.substring(x,x+5));
	    }
	    int num = Arrays.asList(bars).indexOf(Barcode.substring(x,x+5));
	    if(sumOf(s)%10 != num){
		throw new IllegalArgumentException("check digit does not match up");
	    }
	    return s;
	}
    }
}

