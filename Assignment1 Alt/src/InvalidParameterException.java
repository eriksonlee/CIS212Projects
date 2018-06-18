
public class InvalidParameterException extends Exception {
    
    private String errorMsg;
    
    public InvalidParameterException(){
        errorMsg = "Error!";
    }
    public InvalidParameterException(String stringInput){
        errorMsg = "Value cannot be empty. Please enter a valid ID";
    }
    public InvalidParameterException(double doubleInput){
        errorMsg = "Invalid entry " + doubleInput + ". Please enter a positive value";
    }
    public InvalidParameterException(double speedInput, double maxInput){
        errorMsg = "Invalid speed entry " + speedInput + ". Must be positive and cannot exceed the max value of " + maxInput;
    }
    public String getMessage() {
        return errorMsg;
    }
    
    
    
    
    
}
