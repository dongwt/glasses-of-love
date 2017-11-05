package com.dongwt.glasses.api.pagination;

import com.dongwt.glasses.api.request.BasePageRequest;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class CommonPagination<T>  implements Pagination<T> ,Serializable{
    
    private static final long serialVersionUID = 1L;

    private Collection<T> items = new ArrayList<T>();
    
    private Page page = new Page();

    @Override
    public Collection<T> getItems() {
        return items;
    }

    @Override
    public void setItems(Collection<T> items) {
        this.items = items;
    }

    @Override
    public Page getPage() {
        return page;
    }

    @Override
    public void setPage(BasePageRequest request) {
        BeanUtils.copyProperties(request, page);
    }

    @Override
    public void setTotal(Integer total) {
        page.setTotal(total);
    }

}
