package cn.xinill.ttms.service;

import cn.xinill.ttms.pojo.Employee;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 16:09
 */
public interface IEmployeeService {

    /**
     * 查询是否存在该员工
     * @param empNo
     * @return
     */
    boolean existEmpByNo(String empNo);

    /**
     * 添加新员工
     * @param employee
     * @return
     */
    boolean insertEmp(Employee employee);

    /**
     * 职工登录
     * @param no
     * @param pwd
     * @return
     */
    Employee login(String no, String pwd);

    /**
     * 根据 权限查找职工
     * @param role
     * @return
     */
    List<Employee> selectByRole(int role);

    /**
     * 根据 id删除职工账号
     * @param id
     * @return
     */
    Boolean deleteById(int id);

    /**
     * 修改账号权限和状态
     * @param employee
     * @return
     */
    Boolean updateRole(Employee employee);
}
