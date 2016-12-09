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
	toBarcode(_zip);
	s+= "|";
	return s;
    }
    private String bar(char num){
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
	Barcode bar = new Barcode(zip);
	zip = bar.getZip();
	String s = "";
	char[] num  = new char[6];
	for(int x = 0;x < zip.length(); x ++){
	    char[x] = zip.charAt(x));
	s += car(char[x]);
	}	
    }
    //  public static String toZip(String Barcode){
    //	if (Barcode.length()!=) throw new 
    //}
}

