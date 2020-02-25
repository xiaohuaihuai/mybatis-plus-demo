package com.example.mybatis.plus.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaginationRequest<T> implements Serializable {
    private static final long serialVersionUID = 9189790044605284823L;
    private int pageNum;
    private int pageSize;
    private T data;
}
