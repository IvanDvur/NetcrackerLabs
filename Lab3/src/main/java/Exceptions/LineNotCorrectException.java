package Exceptions;

import java.io.IOException;

public class LineNotCorrectException extends IOException {

    public LineNotCorrectException(String message) {
        super(message);
    }
}
