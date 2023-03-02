package model;

import java.time.LocalDate;

public class DigitalTVContract extends Contract {
    /**
     * Поле хранящее пакет каналов
     */
    private ChannelPack channelPack;

    /**
     * Конструктор с требуемыми параметрами, вызывающий родительский конструктор
     * @param startDate дата начала контракта
     * @param endDate дата окончания контракта
     * @param contractNumber номер контракта
     * @param person сущность "Человек"
     * @param channelPack enum пакет каналов
     */
    public DigitalTVContract(LocalDate startDate, LocalDate endDate, Long contractNumber, Person person, ChannelPack channelPack) {
        super(startDate, endDate, contractNumber, person);
        this.channelPack = channelPack;
    }

    public void setChannelPack(ChannelPack channelPack) {
        this.channelPack = channelPack;
    }

    public ChannelPack getChannelPack() {
        return channelPack;
    }

    @Override
    public String toString() {
        return "Цифровое телевидение{" +
                "Пакет каналов=" + channelPack +
                "} " + super.toString();
    }
}
