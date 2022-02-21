package Throwable;

public class PermissionException extends Exception{
    public PermissionException(String message){
        super((message.length()!=0) ? message : "Undefined");
    }
}
