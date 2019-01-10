package cn.itcast.erp.action;

import cn.itcast.biz.IEmpBiz;
import cn.itcast.erp.entity.Emp;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAction {

    private String username;//登录用户名
    private String pwd;//密码
    private IEmpBiz empBiz;//注入业务层

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmpBiz(IEmpBiz empBiz) {
        this.empBiz = empBiz;
    }

    public void checkUser(){
        //查询是否存在
        Emp loginUser = empBiz.findUsernameAndPwd(username,pwd);
        if(loginUser != null){
            //记录当前登录的用户
            ActionContext.getContext().getSession().put("loginUser",loginUser);
            ajaxReturn(true,"登入成功，欢迎你"+loginUser.getName());
        }else {
            ajaxReturn(false,"用户名或密码不正确");
        }
    }

    public void ajaxReturn(boolean success, String message){
        //返回前端的JSON数据
        Map<String, Object> rtn = new HashMap<String, Object>();
        rtn.put("success",success);
        rtn.put("message",message);
        //{"abc":true, "bcd":"dfasdfsdf"}
        write(JSON.toJSONString(rtn));
    }
    public void write(String jsonString){
        try {
            //响应对象
            HttpServletResponse response = ServletActionContext.getResponse();
            //设置编码
            response.setContentType("text/html;charset=utf-8");
            //输出给页面
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
