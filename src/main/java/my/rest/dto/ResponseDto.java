package my.rest.dto;

public class ResponseDto<T> {

    private T data;
    private boolean success;

    public ResponseDto() {
    }

    public ResponseDto(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
