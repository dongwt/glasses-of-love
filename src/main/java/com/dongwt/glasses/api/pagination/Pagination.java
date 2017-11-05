package com.dongwt.glasses.api.pagination;


import com.dongwt.glasses.api.request.BasePageRequest;

import java.util.Collection;

public interface Pagination<T> {

    /**
     * 
     * 功能描述:获取数据列表
     *
     * <pre>
     * Modify Reason:(修改原因,不需覆盖，直接追加.)
     *     dongwt:   2017年2月10日      新建
     * </pre>
     *
     * @return
     */
    Collection<T> getItems();

    /**
     * 
     * 功能描述:设置数据列表
     *
     * <pre>
     * Modify Reason:(修改原因,不需覆盖，直接追加.)
     *     dongwt:   2017年2月10日      新建
     * </pre>
     *
     * @param items
     */
    void setItems(Collection<T> items);

    /**
     * 
     * 功能描述:获取分页信息
     *
     * <pre>
     * Modify Reason:(修改原因,不需覆盖，直接追加.)
     *     dongwt:   2017年2月10日      新建
     * </pre>
     *
     * @return
     */
    Page getPage();

    /**
     * 
     * 功能描述:TODO(描述这个方法的作用)
     *
     * <pre>
     * Modify Reason:(修改原因,不需覆盖，直接追加.)
     *     Administrator:   2017年2月10日      新建
     * </pre>
     *
     * @param request
     */
    void setPage(BasePageRequest request);

    /**
     * 
     * 功能描述:这只总记录数
     *
     * <pre>
     * Modify Reason:(修改原因,不需覆盖，直接追加.)
     *     dongwt:   2017年2月10日      新建
     * </pre>
     *
     * @param total
     */
    void setTotal(Integer total);
}
