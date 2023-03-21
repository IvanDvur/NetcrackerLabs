package repository;

import Exceptions.NoElementWithSuchIdException;
import model.Contract;

import java.util.Arrays;

/**
 * @author Иван Двуреченский
 */

public class ContractRepositoryImpl implements ContractRepository {
    /**
     * Поле-массив выполняющее функции репозитория и хранящее в себе элементы-наследники класса Contract
     */
    protected Contract[] contracts;

    /**
     * Поле хранящее количество элементов в репозитории
     */
    protected int nbOfElems;

    protected int currentId;

    /**
     * Конструктор без параметров, при вызове, поле contracts инициализируется пустым массивом, кол-во эелементов(nbOfElems) также равно 0
     */
    public ContractRepositoryImpl() {
        this.contracts = new Contract[0];
        this.nbOfElems = 0;
    }

    /**
     * Конструктор с параметром initialCapacity позволяет задать первоначальную ёмкость репозитория для сокращения кол-ва операций расширения
     *
     * @param initialCapacity первоначальная ёмкость массива
     */
    public ContractRepositoryImpl(int initialCapacity) {
        this.contracts = new Contract[initialCapacity];
        this.nbOfElems = 0;
        this.currentId = 0;
    }

    /**
     * Добавляет новые контракты в массив contracts. Перед добавлением элементов происходит проверка на наличие резервных
     * мест для добавлени новых элементов. Если резервных мест недостаточно, происходит расширение массива с помощью
     * статического метода Arrays.copyOf(). Расширение производится по формуле: новая ёмкость = (старая ёмкость*3)/2 + 1
     * (по аналогии с механизмом расширения ArrayList). Далее производится циклическое добавление элементов в массив с
     * автоматическим присвоением id равному индексу элемента в массиве.
     *
     * @param newContracts - массив, содержащий контракты, которые необходимо добавить
     */
    @Override
    public void addContracts(Contract[] newContracts) {
        int startIndex = nbOfElems;
        while (nbOfElems + newContracts.length > contracts.length) {
            this.contracts = Arrays.copyOf(this.contracts, (this.contracts.length * 3) / 2 + 1);
        }
        for (int i = startIndex, k = 0; k < newContracts.length; i++) {
            newContracts[k].setId(currentId);
            newContracts[k].getPerson().setId(currentId);
            this.contracts[i] = newContracts[k];
            currentId++;
            k++;
            nbOfElems++;
        }
    }

    /**
     * Возвращает контракт по заданному id. Для поиска используется алгоритм бинарного поиска(Arrays.binarySearch()?).
     * Нижняя граница задана нулевым элементом, верхняя - индексом последнего элемента (nbOfElems-1).
     * В случае если необходимый контракт не найден, выбрасывает NoElementWithSuchIdException и обрабатывает его выводя
     * сообщение о отсутствии элемента с указанным id
     *
     * @param id идентификатор контракта, который необходимо найти
     * @return Контракт по заданному id или null
     * @see NoElementWithSuchIdException
     */
    @Override
    public Contract findContractById(Long id) {
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
        } catch (NoElementWithSuchIdException e) {
            e.printExeption();
        }
        return null;
    }

    /**
     * Метод удаляет контракт по заданному id. Перед удалением производится проверка на наличие элемента с заданным id
     * в массиве с помощью метода findContractById(). Если элемент не был найден - фильтрация элементов не происходит.
     * Удаление производится с помощью промежуточного метода-фильтра filter(), который пропускает все элементы, кроме
     * элемента с указанным id. С целью сокращения кол-ва операций расширения масссива и обхода NullPointerException,
     * null элементы также пропускаются фильтром. Терминальный метод toArray, пересобирает массив с сохранением резервных мест.
     * @param id - id контракта, который необходимо удалить
     * @return true - если элемент был удалён, false - если элемент не найден
     */
    @Override
    public boolean deleteContractById(Long id) {
        if (findContractById(id) == null) {
            return false;
        }
        this.contracts = Arrays.stream(this.contracts).filter(x -> x == null || !x.getId().equals(id)).toArray(Contract[]::new);
        this.nbOfElems--;
        return true;
    }

    /**
     *
     * @return Длина репозитория(с учётом резервных мест)
     */
    @Override
    public long getLength() {
        return contracts.length;
    }

    /**
     *
     * @return Фактическое кол-во элементов()
     */
    @Override
    public long getNbOfElems() {
        return nbOfElems;
    }

    @Override
    public String toString() {
        return "ContractRepositoryImpl{" +
                "contracts=" + Arrays.toString(contracts) +
                '}';
    }
}
