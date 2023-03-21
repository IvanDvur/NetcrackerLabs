package repository;

import model.Contract;
import sorters.SortClient;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;


public class SearchRepositoryImpl extends ContractRepositoryImpl implements SearchContractRepository {

    /**
     * По переданному предикату возвращает новый репозиторий, с отфильтрованными значениями
     * @param condition предикат с условиями фильтрации
     * @return инстанс SearchContractRepository
     */
    @Override
    public SearchContractRepository find(Predicate<Contract> condition) {
        SearchContractRepository newRepo = new SearchRepositoryImpl();
        Arrays.stream(this.contracts)
                .filter(contract -> contract!=null && condition.test(contract))
                .forEach(newRepo::addContract);
        return newRepo;
    }

    /**
     * Вызывает sortClient.sort(), который в зависимости от длины репозитория применяет тот или иной алгоритм сортировки
     * @param comparator
     */
    @Override
    public void sort(Comparator<Contract> comparator) {
        new SortClient().sort(this.contracts, comparator, nbOfElems);
    }

    /**
     * Добавляет контракты по одному, в случае, если нужно будет добавить один контракт
     * @param contract
     */
    @Override
    public void addContract(Contract contract) {
        int insertionIndex = this.nbOfElems;
        while (nbOfElems + 1 > this.contracts.length) {
            this.contracts = Arrays.copyOf(this.contracts, (this.contracts.length * 3) / 2 + 1);
        }
        if (contract.getId() == null) {
            contract.setId(currentId);
            contract.setContractNumber((long) currentId);
            contract.getPerson().setId(currentId);
            currentId++;
        }
        this.contracts[insertionIndex] = contract;
        nbOfElems++;
    }

    /**
     *
     * @return возвращает массив контрактов
     */
    @Override
    public Contract[] getContracts() {
        return this.contracts;
    }

}
