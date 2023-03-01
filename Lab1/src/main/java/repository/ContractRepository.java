package repository;

import model.Contract;

public interface ContractRepository {

    Contract findContractById(Long id);

    void deleteContractById(Long id);

    void addContracts(Contract[] contracts);


}
