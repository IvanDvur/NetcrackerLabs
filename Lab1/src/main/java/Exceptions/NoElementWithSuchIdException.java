package Exceptions;

import java.io.IOException;

public class NoElementWithSuchIdException extends IOException {

    public void printExeption() {
        System.out.println("Контракт с указанным ID не найден");
    }
}
