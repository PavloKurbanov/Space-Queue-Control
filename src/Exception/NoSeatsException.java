package Exception;

public class NoSeatsException extends RuntimeException {
    public NoSeatsException(String massage) {
        super(massage);
    }
}