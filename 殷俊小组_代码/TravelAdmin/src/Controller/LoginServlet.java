package Controller;

import Service.AccountService;
import Service.LoginService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService=new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        JSONObject json = new JSONObject();
       switch (method) {
           case "admin_login":  //管理员登陆
               String admin_name = req.getParameter("username");  //username为管理员账号
               String password = req.getParameter("password");
               System.out.println(admin_name+" "+password);
               //调用Service层的adminLogin方法
               boolean[] results=loginService.adminLogin(admin_name,password);
               System.out.println(results[0]);
               System.out.println(results[1]);
               if(results[0]&&results[1]){
                   json.put("success","true");
                     json.put("result","true");
                   //返回结果
                   resp.setContentType("application/json");
                   resp.setCharacterEncoding("UTF-8");

                   resp.getWriter().write(json.toString());

                   break;
               }else if(results[0]&&!results[1]){
                   json.put("success","true");
                   json.put("result","false");
                   //返回结果
                   resp.setContentType("application/json");
                   resp.setCharacterEncoding("UTF-8");
                   PrintWriter out2 = resp.getWriter();
                   resp.getWriter().write(json.toString());
                   break;
               }
       }

    }
}
