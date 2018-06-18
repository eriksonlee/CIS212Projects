
public class DoesNotExistException extends Exception {

    private String errorMsg;

        public DoesNotExistException(String stringInput){
        errorMsg = "Destination " + stringInput + " does not exist.";
    }
    public String getMessage() {
        return errorMsg;
    }

}
