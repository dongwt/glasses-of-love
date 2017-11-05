package com.dongwt.glasses.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * Function: 基础分页请求实体
 *
 * @author   dongwt
 * @Date	 2017年2月10日		下午3:30:01
 *
 * @see
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 第几页 从1开始
     */
    private Integer pageIndex;

    /**
     * 每页显示多少数据
     */
    private Integer pageSize;

    /**
     * 排序的字段
     */
    private String sortField;

    /**
     * 升序或降序 asc desc
     */
    private String sortOrder;

    /**
     * 功能描述: 获取offset 即mysql语句中的offset
     * @return offset 从0开始
     */
    public Integer getOffset() {
        if (pageIndex != null && pageSize != null) {
            return (pageIndex - 1) * pageSize;
        }
        return 0;
    }

}
