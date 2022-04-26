package com.njupt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/02/14:27
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code,String message){
        this(code,message,null);
    }
}
