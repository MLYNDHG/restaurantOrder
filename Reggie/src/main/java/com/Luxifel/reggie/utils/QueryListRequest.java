package com.Luxifel.reggie.utils;

import lombok.Data;

@Data
public class QueryListRequest<T>{
    private PageCondition pageCondition;
    private T paramsCondition;

    public T getParamsCondition() {
        return paramsCondition;
    }

    public void setParamsCondition(T paramsCondition) {
        this.paramsCondition = paramsCondition;
    }

    public PageCondition getPageCondition() {
        return pageCondition;
    }

    public void setPageCondition(PageCondition pageCondition) {
        this.pageCondition = pageCondition;
    }

}
