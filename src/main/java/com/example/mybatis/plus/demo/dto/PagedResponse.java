package com.example.mybatis.plus.demo.dto;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PagedResponse<T> implements Serializable {
    private static final long serialVersionUID = 1451354512292833876L;
    private long total;
    private List<T> list;

    public PagedResponse() {
    }

    public PagedResponse(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
    }

}
