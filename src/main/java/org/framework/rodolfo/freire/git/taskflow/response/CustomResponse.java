package org.framework.rodolfo.freire.git.taskflow.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse<T> {

    @JsonInclude(Include.NON_NULL)
    private int status;
    @JsonInclude(Include.NON_NULL)
    private String message;
    @JsonInclude(Include.NON_NULL)
    private String error;
    @JsonInclude(Include.NON_NULL)
    private T data;

    public CustomResponse(int status, String message, String error, T data) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public CustomResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public CustomResponse(int status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public CustomResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
