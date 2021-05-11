package cn.xinill.ttms.controller;

import cn.xinill.ttms.common.ServerResponse;
import cn.xinill.ttms.pojo.Employee;
import cn.xinill.ttms.pojo.VOIntegerId;
import cn.xinill.ttms.service.IEmployeeService;
import cn.xinill.ttms.service.ITokenService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 15:55
 */
@Controller
@RequestMapping(value = "/staff")
public class EmployeeController {

    private IEmployeeService employeeService;
    private ITokenService tokenService;
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setTokenService(ITokenService tokenService) {
        this.tokenService = tokenService;
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ServerResponse<Boolean> test(){
        logger.info("测试测试");
        return ServerResponse.createBySuccessMsgData("666", true);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ServerResponse<Boolean> insertEmp(@RequestBody Employee employee){
        try {
            logger.info("新增员工信息："+employee);
            if(employeeService.existEmpByNo(employee.getUsername())){
                logger.warn("用户名已被注册");
                return ServerResponse.createByErrorMsgData("用户名已被注册", false);
            }
            if(employeeService.insertEmp(employee)){
                logger.info("成功添加新职工");
                return ServerResponse.createBySuccessMsgData("成功添加新职工", true);
            }
            logger.warn("添加新职员失败");
            return ServerResponse.createByErrorMsgData("添加新职员失败", false);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("服务器繁忙");
            return ServerResponse.createByErrorMsgData("服务器繁忙", false);
        }


    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ServerResponse<Integer> login(@RequestBody Employee employee,
                                         HttpServletResponse response){
        try {
            logger.info("工作人员请求登陆，账号："+employee.getUsername()+"     密码："+employee.getPassword());
            employee = employeeService.login(employee.getUsername(), employee.getPassword());
            if(employee == null){
                logger.warn("账号或密码错误");
                return ServerResponse.createByErrorMsgData("账号或密码错误", null);
            }
            if(employee.getStatus() == 0){
                logger.warn("账号已被禁用");
                return ServerResponse.createByErrorMsgData("账号已被禁用", null);
            }
            logger.info("登陆成功");
            response.addHeader("token", tokenService.creatUserToken(employee.getEmpId())); //响应头添加token
            return ServerResponse.createBySuccessMsgData("登陆成功", employee.getRole());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("服务器繁忙");
            return ServerResponse.createByErrorMsgData("服务器繁忙", null);
        }


    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public ServerResponse<List<Employee>> getByRole(@RequestParam Integer role){
        try {
            logger.info("请求查询role为"+role+"的职工账号");
            List<Employee> list = employeeService.selectByRole(role);
            logger.info("查询成功");
            return ServerResponse.createBySuccessMsgData("查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("服务器繁忙");
            return ServerResponse.createByErrorMsgData("服务器繁忙", null);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ServerResponse<Boolean> deleteById(@RequestBody VOIntegerId voInteger){
        try {
            logger.info("请求删除职工，职工id："+voInteger.getId());
            if(employeeService.deleteById(voInteger.getId())){
                logger.info("删除成功");
                return ServerResponse.createBySuccessMsgData("删除成功", true);
            }else{
                logger.warn("未发现该用户");
                return ServerResponse.createByErrorMsgData("未发现该用户", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("服务器繁忙");
            return ServerResponse.createByErrorMsgData("服务器繁忙", false);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/updaterole")
    public ServerResponse<Boolean> updateRole(@RequestBody Employee employee){
        try {
            logger.info("更新用户信息："+employee);
            if(employeeService.updateRole(employee)){
                logger.info("修改成功");
                return ServerResponse.createBySuccessMsgData("修改成功", true);
            }else{
                logger.warn("修改失败");
                return ServerResponse.createByErrorMsgData("修改失败", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("服务器繁忙");
            return ServerResponse.createByErrorMsgData("服务器繁忙", false);
        }
    }
}
