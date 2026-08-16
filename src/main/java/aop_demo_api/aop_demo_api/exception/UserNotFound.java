package aop_demo_api.aop_demo_api.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(Long id) {
        super("Record with id: " +id+ " id not found.");
    }
}
