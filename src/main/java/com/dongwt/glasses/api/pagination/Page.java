package com.dongwt.glasses.api.pagination;

import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 第几页从1开始
     */
    private Integer pageIndex;

    /**
     * 每页显示多少数据
     */
    private Integer pageSize;

    /**
     * 要排序的字段
     */
    private String sortField;

    /**
     * 升序或降序 asc desc
     */
    private String sortOrder;

    /**
     * 总计
     */
    private Integer total;
}
