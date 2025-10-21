package instant_order_project.instant_order.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDetails() {
        return this.details;
    }

    @Override
    public String toString() {
        return "{" +
                " timestamp='" + getTimestamp() + "'" +
                ", error='" + getMessage() + "'" +
                ", details='" + getDetails() + "'" +
                "}";
    }
}