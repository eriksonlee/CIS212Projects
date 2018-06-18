
public class AlreadyExistsException extends Exception {

    private String errorMsg;

    public AlreadyExistsException(String stringInput){
        errorMsg = "Destination " + stringInput + " already exists in destination list.";
    }
    public String getMessage() {
        return errorMsg;
    }
}
