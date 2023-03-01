package repository;

import Exceptions.NoElementWithSuchIdException;
import model.Contract;


import java.util.Arrays;

public class ContractRepositoryImpl implements ContractRepository {

    private Contract[] contracts;

    private int nbOfElems;

    public int getLength() {
        return contracts.length;
    }

    @Override
    public String toString() {
        return "ContractRepositoryImpl{" +
                "contracts=" + Arrays.toString(contracts) +
                '}';
    }

    public ContractRepositoryImpl() {
        this.contracts = new Contract[0];
        this.nbOfElems = 0;
    }

    public ContractRepositoryImpl(int ensureCapacity) {
        contracts = new Contract[ensureCapacity];
        this.nbOfElems = 0;
    }

    @Override
    public Contract findContractById(Long id){
        try {
            int low = 0;
            int high = nbOfElems - 1;
            while (low <= high) {
                int mid = low + ((high - low) / 2);
                if (this.contracts[mid].getId() < id) {
                    low = mid + 1;
                } else if (contracts[mid].getId() > id) {
                    high = mid - 1;
                } else if (contracts[mid].getId().equals(id)) {
                    return contracts[mid];
                }
            }
            throw new NoElementWithSuchIdException();
        }catch (NoElementWithSuchIdException e){
            e.printExeption();
        }
        return null;
    }

    @Override
    public boolean deleteContractById(Long id) {
        contracts = Arrays.stream(contracts).filter(x -> !x.getId().equals(id) && x != null).toArray(Contract[]::new);
        this.nbOfElems--;
        return true;
    }

    @Override
    public void addContracts(Contract[] newContracts) {
        int startIndex = nbOfElems;
        while (nbOfElems + newContracts.length > contracts.length) {
            this.contracts = Arrays.copyOf(this.contracts, (this.contracts.length * 3) / 2 + 1);
        }
        for (int i = startIndex, k = 0; i < newContracts.length; i++) {
            newContracts[k].setId(((long) i));
            this.contracts[i] = newContracts[k];
            k++;
            nbOfElems++;
        }
    }
}
