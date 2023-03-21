package sorters;

import model.Contract;

import java.util.Comparator;

public class BubbleSorter implements ISorter{

    @Override
    public void sort(Contract[] arr, Comparator<Contract> comp,int lastIndex) {
        for(int out = lastIndex-1;out>0;out--){
            for (int in = 0; in<out;in++){
                if(comp.compare(arr[in], arr[in + 1]) > 0){
                    Contract temp = arr[in];
                    arr[in] = arr[in+1];
                    arr[in+1] = temp;
                }
            }
        }
    }
}
