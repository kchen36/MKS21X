public class SuperArray implements Iterablels<String>{
    private int[] data;
    private int size;
    public SuperArray(){
	data = new int[10];
	size = 0;
    }
    public SuperArray(int initialCapacity){
	if(initialCapacity < 0){
	   throw new IndexOutOfBoundsException();
	}
	data = new int[initialCapacity];
	size = 0;
    }

    public int size(){
	return size;
    }
   
    public void add(int n){
	if(size == data.length) this.grow();
	data[size()] = n;
	size +=1;
    }
    int get(int index){
	if(index < 0 || index >= size()){
	   throw new IndexOutOfBoundsException();
	}
	return data[index];
    }


    private void grow(){
	int[] x = new int[size * 2];
	for( int y = 0;y< size; y +=1){
	   x[y] = data[y];
	}
	data = x;
    }
    public String toString(){
	if (size == 0){
	   return "[]";
	}
	String str= "[";
	str += String.valueOf(data[0]);
	for(int x =1; x <size; x++){
	   str += ", ";
	   str+= String.valueOf(data[x]);
	}
	str+="]";
	return str;
    }
    public String toStringDebug(){
	int index = 0;
	String str= "[";
	if(size > 0){
	   int x = 1;
	   str += String.valueOf(data[0]);
	   for(x = 1; x <size; x++){
		str += ", ";
		str+= String.valueOf(data[x]);
		index +=1;
	   }
	}
	for(int x = index; x <data.length; x++){
	   str += ", _";
	}
	str+="]";
	return str;
    }

    public void clear(){
	size = 0;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public int set(int index, int element){
	if(index < 0 || index >= size()){
	   throw new IndexOutOfBoundsException();
	}
	int x = data[index];
	data[index] = element;
	return x;
    }
    public void add(int index, int element){
	if(index < 0 || index > size()){
	   throw new IndexOutOfBoundsException();
	}
	if(data.length == size){
	   this.grow();
	   size+= 1;
	}
	else size += 1;
	for(int x = size - 1; x > index; x -=1){
	   data[x] = data[x - 1];
	}
        data[index] = element;
    }
    int remove(int index){
	if(index < 0 || index >= size()){
	   throw new IndexOutOfBoundsException();
	}
	int old = data[index];
	for(int i = index; i < size-1; i++){
	   data[i] = data[i+1];
	}

	size--;
	return old;
    }

    int[] toArray(){
	int[] temp = new int[size];

	for(int i = 0; i < size; i++){
	   temp[i] = data[i];
	}
	return temp;
    }

    int indexOf(int i){
	int index = -1;
	int ln = data.length;
	
	for(int j = 0; index < 0 && j < ln; j++){
	   if(data[j] == i){
		index = j;
	   }
	}

	return index;
    }
    
    int lastIndexOf(int i){
	int index = -1;
	for(int j = data.length-1; index < 0 && j >= 0; j--){
	   if(data[j] == i){
		index = j;
	   }
	}
	return index;	
    }
    
}

