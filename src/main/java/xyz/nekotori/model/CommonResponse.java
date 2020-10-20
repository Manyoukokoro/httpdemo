package xyz.nekotori.model;

import lombok.Getter;

/**
 * Author: Dengjay
 * Date: 2020/10/19
 * Time: 11:11
 */

public class CommonResponse<T> {
    @Getter
    private final String STATUS;

    private T content;
    public CommonResponse(String status) {
        STATUS = status;
    }

    public CommonResponse<T> withContent(T content){
        this.content = content;
        return this;
    }
}
