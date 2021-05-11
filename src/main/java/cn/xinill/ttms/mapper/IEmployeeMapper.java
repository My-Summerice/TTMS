package cn.xinill.ttms.mapper;

import cn.xinill.ttms.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 16:14
 */
@Mapper
public interface IEmployeeMapper {

    /**
     * 根据用户名查询账号是否存在
     */
    int findEmpByNo(String empNo);

    /**
     * 添加新账号
     */
    int insertEmp(Employee employee);

    /**
     * 根据 No查找账号
     */
    Employee selectByNo(String username);

    /**
     * 根据 权限查找职工账号
     */
    List<Employee> selectByRole(String roles);
    /**
     * 根据 id删除职工账号
     */
    int deleteById(int id);

    /**
     * 修改用户权限和状态
     */
    int updateRole(Employee employee);

    /**
     * 修改用户密码
     */
    int updatePwd(Employee employee);
}
