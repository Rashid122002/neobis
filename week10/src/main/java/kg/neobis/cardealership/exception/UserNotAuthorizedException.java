package kg.neobis.cardealership.exception;

import org.springframework.http.HttpStatus;

public class UserNotAuthorizedException extends RuntimeException {

    private static final HttpStatus STATUS = HttpStatus.UNAUTHORIZED;

    public UserNotAuthorizedException(String message){
        super(message);
    }

    public UserNotAuthorizedException(){}

    public HttpStatus getSTATUS(){
        return STATUS;
    }
}
