package xyz.nekotori.common;

import lombok.Getter;

/**
 * Author: Dengjay
 * Date: 2020/10/19
 * Time: 11:11
 */

public class CommonResponse<T> {
    @Getter
    private final Status STATUS;

    @Getter
    private String message;

    @Getter
    private T content;

    public CommonResponse(String status) {
        STATUS = Status.of(status);
    }

    public CommonResponse<T> withMessage(String message){
        this.message = message;
        return this;
    }

    public CommonResponse<T> withContent(T content){
        this.content = content;
        return this;
    }
}
