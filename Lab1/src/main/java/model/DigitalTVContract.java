package model;

import java.time.LocalDate;

public class DigitalTVContract extends Contract {

    private ChannelPack channelPack;


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
