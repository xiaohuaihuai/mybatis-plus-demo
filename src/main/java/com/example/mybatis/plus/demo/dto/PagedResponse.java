package com.example.mybatis.plus.demo.dto;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PagedResponse<T> extends PageInfo<T> {
    private static final long serialVersionUID = -4191090356580323912L;

    public PagedResponse() {
        super();
    }

    public PagedResponse(List<T> list) {
        super(list);
    }
}
