package ch.noseryoung.realestate.core.exception.exposederrors;

import java.time.LocalDate;

public class ApiError {
    private String path;
    private LocalDate timeStamp;
    private MyError error;

    public ApiError() {
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public ApiError setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public ApiError build () {
        return this;
    }

    public MyError getError() {
        return error;
    }

    public ApiError setError(MyError error) {
        this.error = error;
        return this;
    }

    public String getPath() {
        return path;
    }

    public ApiError setPath(String path) {
        this.path = path;
        return this;
    }
}
