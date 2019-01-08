package cn.itcast.erp.action;

import cn.itcast.biz.IDepBiz;
import cn.itcast.erp.entity.Dep;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepAction  {
    /**
     * 部门Action
     * @author Administrator
     */
    private Dep dep;//用于编辑修改
    private IDepBiz depBiz;
    private Dep dep1;
    private Dep dep2;
    private Object param;
    private int page;//页码
    private int rows;//每页的记录数
    private long id;

    public void setDepBiz(IDepBiz depBiz) {
        this.depBiz = depBiz;
    }



    public Dep getDep1() {
        return dep1;
    }

    public  void setDep1(Dep dep1) {
        this.dep1 = dep1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void list(){
        List<Dep> list = depBiz.getList();
        String jsonString = JSON.toJSONString(list);
        write(jsonString);
    }

    public Dep getDep2() {
        return dep2;
    }

    public void setDep2(Dep dep2) {
        this.dep2 = dep2;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 条件查询
     */
    public void getlist(){
        System.out.println("页码："+page+"记录数："+rows);
        //因为页面是从1开始（数据库应该从0开始）
        int firstresult = (page - 1) * rows;
        List<Dep> list = depBiz.getList(dep1 ,dep2,param,firstresult,rows);
        long total = depBiz.getCount(dep1 ,dep2,param);
        Map<String,Object> mapData = new HashMap<String,Object>();
        mapData.put("total",total);
        mapData.put("rows",list);
        String jsonString = JSON.toJSONString(mapData);
        write(jsonString);
    }
    public void add(){
        //{"success":true,"maessage":""}
        //json返回数据给前端
       try{
           depBiz.add(dep);
           ajaxReturn(true,"添加成功");
       }catch (Exception e)
       {
           e.printStackTrace();
           ajaxReturn(false,"删除失败");
       }
    }

    public void delete(){
        try{
            depBiz.delete(id);
            ajaxReturn(true,"删除成功");
        }catch (Exception e)
        {
            e.printStackTrace();
            ajaxReturn(false,"删除失败");
        }
    }

    /**
     * //{"dep.name":"管理员组","dep.tele":"000000","uuid":1}
     * @param jsonString JSON数据字符串
     * @param prefix  要加上的前缀
     * @return
     */
    public String mapData(String jsonString ,String prefix){
        Map<String,Object> map = JSON.parseObject(jsonString);
        //存储key加上前缀后的值
        Map<String,Object> dataMap = new HashMap<String,Object>();
        //给每个key值加上前缀
        for(String key:map.keySet()){
            dataMap.put(prefix + "."+key,map.get(key));
        }
    return JSON.toJSONString(dataMap);
    }
    /**
     * 通过编号查询对象
     */
    public void get(){
        Dep dep = depBiz.get(id);
        String jsonString = JSON.toJSONString(dep);
        System.out.println("转换前："+jsonString);
        //{"name":"管理员组","tele":"000000","uuid":1}
        String jsonStringAfter = mapData(jsonString,"dep");
        System.out.println("转换后："+jsonStringAfter);
        write(jsonStringAfter);
    }

    public void update() {
        try {
            depBiz.update(dep);
            ajaxReturn(true,"修改成功");
        }
        catch(Exception e){
            e.printStackTrace();
            ajaxReturn(false,"修改失败");
        }
    }










    public void ajaxReturn(boolean success,String message){
        Map<String,Object> rtn = new HashMap<String,Object>();
            rtn.put("success",success);
            rtn.put("message",message);
            write(JSON.toJSONString(rtn));
    }

    public void write(String jsonString){
        try{
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(jsonString);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
