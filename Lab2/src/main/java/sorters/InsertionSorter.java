package sorters;

import model.Contract;

import java.util.Comparator;

public class InsertionSorter implements ISorter{


    @Override
    public void sort(Contract[] arr, Comparator<Contract> comp,int lastIndex) {
        int in,out;
        for(out = 1;out<lastIndex;out++){
            Contract temp = arr[out];
            in = out;

            while (in>0 && comp.compare(arr[in-1],temp)>0){
                arr[in] = arr[in-1];
                --in;
            }
            arr[in] = temp;
        }
    }


}
