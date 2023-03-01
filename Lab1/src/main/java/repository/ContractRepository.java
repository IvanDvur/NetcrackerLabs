package repository;

import Exceptions.NoElementWithSuchIdException;
import model.Contract;

public interface ContractRepository {

    Contract findContractById(Long id) throws NoElementWithSuchIdException;

    boolean deleteContractById(Long id) throws NoElementWithSuchIdException;

    void addContracts(Contract[] contracts);


}
