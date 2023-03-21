package sorters;

import model.Contract;

import java.util.Comparator;

public interface ISorter {
     void sort(Contract[] arr, Comparator<Contract> comp,int lastIndex);
}
