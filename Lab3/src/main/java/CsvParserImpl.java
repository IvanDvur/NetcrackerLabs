import Exceptions.LineNotCorrectException;
import model.*;

import repository.SearchContractRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvParserImpl implements CsvParser {

    /**
     * Проводит проверку на null(parsedContracts == null, если в csv файле есть ошибки), а затем по одному добавляет
     * @param csvFile .csv файл с контрактами
     * @param repository репозиторий, в который необходимо загрузить контракты.
     */
    @Override
    public void loadToRepo(File csvFile, SearchContractRepository repository) {
        List<Contract> parsedContracts = readCsv(csvFile);
        if (parsedContracts != null) {
            parsedContracts.forEach(repository::addContract);
        }
    }

    /**
     * Читает .csv файл парся его построчно
     * @param csvFile файл контрактов для парсинга
     * @return Список контрактов
     */
    private List<Contract> readCsv(File csvFile) {
        try (BufferedReader bf = new BufferedReader(new FileReader(csvFile))) {
            List<Contract> parsedContracts = new ArrayList<>();
            Contract ct;
            String line;
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                if ((ct = parseLine(line)) != null) {
                    parsedContracts.add(ct);
                }
            }
            return parsedContracts;
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Парсит линию, возвращая объект супертипа Contract
     * @param line строка для парсинга
     * @return инстанс Contract
     */
    private Contract parseLine(String line) {
        try {
            String[] splittedLine = line.split(";");
            Contract newContract = parseContractInfo(splittedLine[6], splittedLine[7]);
            Person person = new Person();
            if (splittedLine.length != 8) {
                throw new LineNotCorrectException("Файл содержит ошибку");
            }
            newContract.setStartDate(LocalDate.parse(splittedLine[0], DateTimeFormatter.ofPattern("dd-MM-uuuu")));
            newContract.setEndDate(LocalDate.parse(splittedLine[1], DateTimeFormatter.ofPattern("dd-MM-uuuu")));
            person.setFullname(splittedLine[2]);
            person.setGender(Boolean.parseBoolean(splittedLine[3]));
            person.setBirthday(LocalDate.parse(splittedLine[4], DateTimeFormatter.ofPattern("dd-MM-uuuu")));
            person.setPassportNumber(splittedLine[5]);
            newContract.setPerson(person);
            return newContract;
        } catch (LineNotCorrectException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Парсит последние две строки возвращая инстанс конкретного репозитория
     * @param contractType тип контракта (7 колонка, c 6 индексом)
     * @param contractInfo информация о контракте(8 колонка, 7 индекс)
     * @return инстанс контракта
     */
    private Contract parseContractInfo(String contractType, String contractInfo) {
        if (contractType.equalsIgnoreCase("tv")) {
            return new DigitalTVContract(ChannelPack.valueOf(contractInfo));
        } else if (contractType.equalsIgnoreCase("internet")) {
            return new InternetContract(Integer.parseInt(contractInfo));
        } else {
            String[] mobileInfo = contractInfo.split(",");
            return new MobileCommunicationContract(
                    Integer.parseInt(mobileInfo[0]),
                    Integer.parseInt(mobileInfo[1]),
                    Integer.parseInt(mobileInfo[2]));
        }
    }
}
