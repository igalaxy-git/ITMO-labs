package Throwable;

public class PermissionException extends RuntimeException{
    PermissionException(String message){
        super((message.length()!=0) ? message : "Undefined");
    }
}
