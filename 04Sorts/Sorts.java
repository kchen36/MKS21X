public class Sorts{
    public static String names(){
	return "09.Chen.Kerry";
    }
    public static void selectionSort(int[] data){
	for(int x = 0; x < data.length - 1;x++){
	    int val = data[x];
	    int index = 0;
	    for(int y = x+1;y < data.length; y ++){
		if (data[y] > val){
		    val = data[y];
		    index = y;
		}
	    } 
	    data[index] = data[x];
	    data[x] = val;
	}
    }
    public static void insertionSort(int[] data){
	for(int x = 1; x < data.length; x ++){
	    if (data[x] < data[x -1]){
		int temp = data[x];
		int y;
		for(y = x;y > 0 && data[y-1] > temp; y --){
			data[y] = data[y-1];
		}
		data[y] = temp;
	    }
	}
    }
    public static void bubbleSort(int[] data){
	int swap = 1;
	while(swap != 0){ 
	    swap = 0;
	    int pass = 0;
	    for(int x = 0; x < data.length - (1 + pass)  ;x++){
		if (data[x] > data[x+1]){
		    int temp = data[x];
		    data[x] = data[x+1];
		    data[x+1] = temp;
		    swap++;
		    pass++;
		}
	    }
	}
    }
    public static void main(String[]args){
	int[] vals = {1,5,6,3,-12,12,111,14,0,1};
	bubbleSort(vals);
	for(int x = 0; x < vals.length;x++){
	    System.out.println(vals[x]);
	}
    }
}
