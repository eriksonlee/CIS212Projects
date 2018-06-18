
public class ListFullException extends Exception {

    private String errorMsg;

    public ListFullException(String stringInput){
        errorMsg = "Destination list is full!";
    }
    public String getMessage() {
        return errorMsg;
    }
}
