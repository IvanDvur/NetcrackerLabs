package Exceptions;

public class NoElementWithSuchIdException extends Exception {

    public void printExeption() {
        System.out.println("Контракт с указанным ID не найден");
    }
}
