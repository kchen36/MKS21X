import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    private int index = 0;
    private SuperArray data;
    public SuperArrayIterator(){
		data = new SuperArray();
		index = 0;
    }
    public SuperArrayIterator(SuperArray ary){
	data = ary;
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
    public boolean hasNext(){
        return index < data.size();
    }
    public String next(){
	if (hasNext()){
	    index ++;
	    return data.getVal(index - 1);
	}else{
	    throw new NoSuchElementException();
	}
    }
}
