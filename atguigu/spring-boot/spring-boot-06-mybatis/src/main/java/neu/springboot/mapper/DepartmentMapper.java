package neu.springboot.mapper;


import neu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//这是一个操作数据库的方法
//@Mapper
public interface DepartmentMapper {

        @Select("select * from department where id=#{id}")
        public Department getDeptById(Integer id);

        @Delete("delete from department where id=#{id}")
        public int deleteDeptId(Integer id);

        @Options(useGeneratedKeys = true,keyProperty = "id")
        @Insert("insert into department(departmentName) values(#{departmentName})")
        public int insertDept(Department department);

        @Update("update department set departmentName=#{departmentName} where id=#{id}")
        public int updateDept(Department department);
}
