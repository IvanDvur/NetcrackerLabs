package repository;

import model.Contract;

public interface ContractRepository {

    Contract findContractById(Long id);

    boolean deleteContractById(Long id);

    void addContracts(Contract[] contracts);

    long getLength();

    long getNbOfElems();

}
