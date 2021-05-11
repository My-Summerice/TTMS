package cn.xinill.ttms.service.impl;

import cn.xinill.ttms.mapper.IEmployeeMapper;
import cn.xinill.ttms.pojo.Employee;
import cn.xinill.ttms.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 16:09
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeMapper employeeMapper;

    @Autowired(required = false)
    public void setEmployeeMapper(IEmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public boolean existEmpByNo(String empNo) {
        return 1 == employeeMapper.findEmpByNo(empNo);
    }

    @Override
    public boolean insertEmp(Employee employee) {
        return 1 == employeeMapper.insertEmp(employee);
    }

    @Override
    public Employee login(String username, String password) {
        Employee employee = employeeMapper.selectByNo(username);
        if(employee == null){
            System.out.println("账号不存在");
        }else if(!employee.getPassword().equals(password)){
            System.out.println("密码错误");
        }else{
            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> selectByRole(int role) {
        if(role == 0){
            return employeeMapper.selectByRole("(1,2,3)");
        }else{
            return employeeMapper.selectByRole("("+role+")");
        }
    }

    @Override
    public Boolean deleteById(int id) {
        return 1 == employeeMapper.deleteById(id);
    }

    @Override
    public Boolean updateRole(Employee employee) {
        employeeMapper.updateRole(employee);
        return true;
    }
}
