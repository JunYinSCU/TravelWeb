package Controller;
import Service.AccountService;
import com.google.gson.Gson;
import entity.Account;
import entity.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private AccountService accountService=new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "checkBan":
                String youkezhanghao = req.getParameter("youkezhanghao");
                boolean isBanned = accountService.checkBan(youkezhanghao);
                System.out.println(isBanned);
                if(isBanned){
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter out2 = resp.getWriter();
                    out2.write("{\"success\": true, \"result\": true}");
                    out2.flush();
                }
                else{
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter out2 = resp.getWriter();
                    out2.write("{\"success\": true, \"result\": false}");
                    out2.flush();
                }
                break;
            case "list":
                System.out.println("获取列表");
                // 调用service层的list方法获取账号列表
                List<Account> accountList = accountService.list();
                // 将账号列表转为json存入request域
                Gson gson = new Gson();
                String json = gson.toJson(accountList);
                //返回数据
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);//将json数据返回
                //System.out.println(json);
                break;
            case "ban": //封禁
                System.out.println("封禁");
                //获取表单数据id，这是要封禁的值
                String idStr = req.getParameter("id");
                //将id转换为int类型
                Long id = Long.parseLong(idStr);
                //System.out.println("id:"+id);
                //获取封禁类型(0为永久，1为1小时，2为1天，3为一月,4为一年)
                String typeStr = req.getParameter("type");
                //将bantype转化为int类型
                int type = Integer.parseInt(typeStr);
                //System.out.println("type:"+type);
                String reason = req.getParameter("reason");
                //System.out.println("reason:"+reason);
                //调用service层的ban方法
                //System.out.println("ban id:"+id);
                accountService.ban(id,type,reason);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out2 = resp.getWriter();
                out2.write("{\"success\":" + true + "}");
                out2.flush();
                break;
            case "unban": //解封
                //获取表单数据id，这是要解封的值
                idStr = req.getParameter("id");
                //将id转换为int类型
                id = Long.parseLong(idStr);
                //调用service层的unban方法
                accountService.unban(id);
                System.out.println("unban id:"+id);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out2 = resp.getWriter();
                out2.write("{\"success\":" + true + "}");
                out2.flush();
                break;
            case "reset":
                //获取表单数据id，这是要解封的值
                idStr = req.getParameter("id");
                //将id转换为int类型
                id = Long.parseLong(idStr);
                accountService.reset(id);
                System.out.println("reset id:"+id);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out2 = resp.getWriter();
                out2.write("{\"success\":" + true + "}");
                out2.flush();
                break;
            case "update":
                //获取数据表单
                idStr=req.getParameter("id");
                id = Long.parseLong(idStr);
                youkezhanghao=req.getParameter("youkezhanghao");
                String youkexingming=req.getParameter("youkexingming");
                String xingbie=req.getParameter("xingbie");
                String lianxifangshi=req.getParameter("lianxifangshi");
                String shenfenzheng=req.getParameter("shenfenzheng");
                String youxiang=req.getParameter("youxiang");
                String is_bannedStr=req.getParameter("is_banned");
                System.out.println("update id:"+id);
                System.out.println("update youkezhanghao:"+youkezhanghao);
                System.out.println("update youkexingming:"+youkexingming);
                System.out.println("update xingbie:"+xingbie);
                System.out.println("update lianxifangshi:"+lianxifangshi);
                System.out.println("update shenfenzheng:"+shenfenzheng);
                System.out.println("update youxiang:"+youxiang);
                System.out.println("update is_banned:"+is_bannedStr);
                Account account=new Account(1,youkezhanghao,youkexingming,
                        xingbie,lianxifangshi,shenfenzheng,youxiang,is_bannedStr);

                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.write("{\"success\":" + true + "}");
                out.flush();
                break;

            case "search":
                //获取填写的搜索字段(id、youkezhanghao、youxiang)
                idStr = req.getParameter("id");
                id = (idStr == null || idStr.isEmpty()) ? -1 : Long.parseLong(idStr); //如果为空则为-1
                youkezhanghao=req.getParameter("youkezhanghao");
                youkezhanghao = (youkezhanghao != null && !youkezhanghao.isEmpty()) ? youkezhanghao : null; //如果为空则为null
                youxiang=req.getParameter("youxiang");
                youxiang = (youxiang != null && !youxiang.isEmpty()) ? youxiang : null; //如果为空则为null
                System.out.println("Search Params - ID: " + id + ", Youkezhanghao: " + youkezhanghao + ", youxiang: " + youxiang);//打印搜索字段

                List<Account> filteredProducts = accountService.search(id, youkezhanghao, youxiang); //调用service层的search方法

                //将搜索结果转换为json再发送
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("data", filteredProducts); // Actual data array
                String searchJson = new Gson().toJson(responseMap);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(searchJson);
                break;
        }
    }
}
