package com.Luxifel.reggie.model;

import com.Luxifel.reggie.mbg.model.Employee;
import com.Luxifel.reggie.utils.PageCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com.Luxifel.reggie.model.EmployeeExp员工信息扩展")
@Data
public class EmployeeExp extends Employee {

//    private PageCondition pageCondition;
//
//    public PageCondition getPageCondition() {
//        return pageCondition;
//    }
//
//    public void setPageCondition(PageCondition pageCondition) {
//        this.pageCondition = pageCondition;
//    }



//    /**
//     * 员工列表
//     */
//    @ApiModelProperty(value="员工列表")
//    List<Employee> employeeList;

    private static final long serialVersionUID = 1L;
}
