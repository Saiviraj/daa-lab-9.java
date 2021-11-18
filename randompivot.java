import java.util.*;


public class randompivot {

    public static void swap(ArrayList<Integer> elements, int i, int j){
        //Method to swap 2 elements in an arraylist
        int temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
   
    public static int partition(ArrayList<Integer> elements, int beg, int end){
       
        //Get a random pivot between beg and end
        int random=beg + ((int)Math.random()*(elements.size()))/(end-beg+1);

        //New position of pivot element
        int last=end;
       
        //Move the pivot element to right edge of the array
        swap(elements, random, end);
        end--;
       
        while(beg<=end){
            if(elements.get(beg)<elements.get(last)) beg++; //Accumulate smaller elements to the left
            else {
                swap(elements, beg, end);
                end--;
            }
        }
       
        //Move pivot element to its correct position
        swap(elements, beg, last);
       
        return beg;
    }
   
    public static void quicksort(ArrayList<Integer> elements, int beg, int end){
        if(beg>=end) return;
        if(beg<0) return;
        if(end>elements.size()-1) return;
       
        int pivot = partition(elements, beg, end);
        quicksort(elements, beg, pivot-1);
        quicksort(elements, pivot+1, end);
    }
   
   
    public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<Integer>();
        elements.add(11);
        elements.add(20);
        elements.add(3);
        elements.add(11);
        elements.add(2);
        elements.add(13);
       
        quicksort(elements,0, elements.size()-1);
       
        for(int i=0;i<elements.size();i++){
            System.out.println(elements.get(i));
        }
    }
}
