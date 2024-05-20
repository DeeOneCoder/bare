import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public int getSmallestInteger(int ...a){
        int length = a.length;
        Arrays.sort(a);
        int smallest = a[0];
        int largest = a[length-1];

        //Converting the array to a list for ease of manipulation
        List<Integer> numberList = new ArrayList<>();
        for( int x : a ){
            numberList.add(x);
        }

        while(smallest < largest ){
            if(smallest == 0){
                smallest++;
                continue;
            }
            if( numberList.contains(smallest) ){
                smallest++;
                continue;
            }
            if(!numberList.contains(smallest) && smallest < 0 ){
                smallest++;
            }
            if(!numberList.contains(smallest) && smallest > 0 ){
                return smallest;
            }
        }
        return smallest;

    }


    public static void main(String[] args) {
        Main main = new Main();
        int smallest = main.getSmallestInteger(-3,-3,-4,-1,0,1,3,5,4,3,6);
        System.out.println(smallest);
//        System.out.println("Hello world!");
    }
}