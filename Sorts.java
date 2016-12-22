public class Sorts{
    public static String names(){
	return "09.Chen.Kerry";
    }
    public static void selectionSort(int[] data){
	int val;
	int y;
	for(int x = 0; x < data.length - 1;x++){
	    val = data[x];
	    for(y = x+1;y < data.length; y ++){
		if (data[y] > val){
		    val = data[y];
		}
	    } 
	    data[y] = data[x];
	    data[x] = val;
	}
    }
    public static void main(String[]args){
	int[] vals = {1,5,6,3,12,13,14,0,1};
	selectionSort(vals);
	for(int x = 0; x < vals.length;x++){
	    System.out.println(vals[x]);
	}
    }
}
