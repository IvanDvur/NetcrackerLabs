package repository;

import Exceptions.NoElementWithSuchIdException;
import model.Contract;


import java.util.Arrays;

public class ContractRepositoryImpl implements ContractRepository {

    private Contract[] contracts = new Contract[0];

    @Override
    public Contract findContractById(Long id) {
        try {
            int low = 0;
            int high = contracts.length - 1;
            while (low <= high) {
                int mid = high / 2;
                if (contracts[mid].getId() < id) {
                    low = mid + 1;
                } else if (contracts[mid].getId() > id) {
                    high = mid - 1;
                } else if (contracts[mid].getId() == id) {
                    return contracts[mid];
                }
            }
            throw new NoElementWithSuchIdException();
        } catch (NoElementWithSuchIdException e) {
            e.printExeption();
        }
        return null;
    }

    @Override
    public void deleteContractById(Long id) {
//            TODO
    }

    @Override
    public void addContracts(Contract[] newContracts) {
        int lastIndex = this.contracts.length;
        this.contracts = Arrays.copyOf(contracts, contracts.length + newContracts.length);
        for (int i = lastIndex, k = 0; i < contracts.length; i++) {
            newContracts[k].setId(((long) i));
            this.contracts[i] = newContracts[k];
            k++;
        }
    }
}
