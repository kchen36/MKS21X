public class Barcode implements Comparable<Barcode>{
   private String _zip;
   private int _checkDigit;
// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length() = 5 && zip.matches("[0-9]+")){
	  _zip = zip;
	  int sum = 0;
	  for(int x; x < _zip.length();x++){
	      sum += parseInt(_zip.charAt(x));
	  }
	  _checkDigit = sum % 10;
      }
      else{
	  throw new RuntimeException;
      }
}

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode copy = new Barcode(_zip);
      return copy;
}


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){}

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){}


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    
}

