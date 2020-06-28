package neu.springboot.mapper;

import neu.springboot.bean.EmployeeA;

public interface EmployeeAMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeA record);

    int insertSelective(EmployeeA record);

    EmployeeA selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeA record);

    int updateByPrimaryKey(EmployeeA record);
}