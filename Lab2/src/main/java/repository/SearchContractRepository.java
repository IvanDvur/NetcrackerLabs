package repository;

import model.Contract;

import java.util.Comparator;
import java.util.function.Predicate;

public interface SearchContractRepository extends ContractRepository{

    ContractRepository find(Predicate<Contract> condition);

    void sort(Comparator<Contract> comparator);


    void addContract(Contract contract);

    Contract[] getContracts();
}
