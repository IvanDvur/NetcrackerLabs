package sorters;

import model.Contract;

import java.util.Comparator;

public class SortClient implements ISorter{

    private Contract[] arr;


    @Override
    public void sort(Contract[] arr, Comparator<Contract> comp,int lastIndex) {
        if(arr.length<3){
            new BubbleSorter().sort(arr,comp,lastIndex);
        } else if (arr.length>3 && arr.length<6) {
            new InsertionSorter().sort(arr,comp,lastIndex);
        }else{
            new QuickSorter().sort(arr, comp,lastIndex);
        }
    }

}
