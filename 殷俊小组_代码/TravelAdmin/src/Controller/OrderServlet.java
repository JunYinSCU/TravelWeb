package Controller;

import Service.OrderService;
import Service.ProductService;
import com.google.gson.Gson;
import entity.Order;
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

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list":
                System.out.println("获取列表");
                // 调用service层的list方法获取产品列表
                List<Order> orderList = orderService.list();
                // 将产品列表转为json存入request域
                Gson gson = new Gson();
                String json = gson.toJson(orderList);
                //返回数据
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);//将json数据返回
                break;

            case "save":
                // 获取表单数据
                String youkezhanghao = req.getParameter("youkezhanghao");
                String lianxifangshi = req.getParameter("lianxifangshi");
                String shenfenzheng = req.getParameter("shenfenzheng");
                String jingdianmingcheng = req.getParameter("jingdianmingcheng");
                int piaoshu = Integer.parseInt(req.getParameter("piaoshu"));
                String zongjine = req.getParameter("zongjine");
                String goupiaoshijian = req.getParameter("goupiaoshijian");

                //打印获取到的表单数据到控制台
                System.out.println("add youkezhanghao: "+youkezhanghao);
                System.out.println("add lianxifangshi: "+lianxifangshi);
                System.out.println("add shenfenzheng: "+shenfenzheng);
                System.out.println("add jingdianmingcheng: "+jingdianmingcheng);
                System.out.println("add piaoshu: "+piaoshu);
                System.out.println("add zongjine: "+zongjine);
                System.out.println("add goupiaoshijian: "+goupiaoshijian);

                // 创建产品对象并保存
                Order order = new Order(1,youkezhanghao, lianxifangshi, shenfenzheng,
                        jingdianmingcheng, piaoshu, zongjine,
                        goupiaoshijian);

                //这里有try catch是因为dao层用了日期转换，所以要处理异常
                //如果你的方法没有抛出异常，可以不用try catch，直接调用service层的save方法
                try {
                    // 调用service层的save方法保存产品
                    orderService.save(order);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.write("{\"success\":" + true + "}");
                out.flush();
                break;
            case "update":
                //获取表单数据
                String idStr = req.getParameter("id");
                long id = Long.parseLong(idStr);
                youkezhanghao = req.getParameter("youkezhanghao");
                lianxifangshi = req.getParameter("lianxifangshi");
                shenfenzheng = req.getParameter("shenfenzheng");
                jingdianmingcheng = req.getParameter("jingdianmingcheng");
                piaoshu = Integer.parseInt(req.getParameter("piaoshu"));
                zongjine = req.getParameter("zongjine");
                goupiaoshijian = req.getParameter("goupiaoshijian");

                System.out.println("update id:" + id);
                System.out.println("update youkezhanghao: "+youkezhanghao);
                System.out.println("update lianxifangshi: "+lianxifangshi);
                System.out.println("update shenfenzheng: "+shenfenzheng);
                System.out.println("update jingdianmingcheng: "+jingdianmingcheng);
                System.out.println("update piaoshu: "+piaoshu);
                System.out.println("update zongjine: "+zongjine);
                System.out.println("update goupiaoshijian: "+goupiaoshijian);
                //创建product对象
                order = new Order(id,youkezhanghao, lianxifangshi, shenfenzheng,
                        jingdianmingcheng, piaoshu, zongjine,
                        goupiaoshijian);
                //调用service层的update方法
                orderService.update(order);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out1 = resp.getWriter();
                out1.write("{\"success\":" + true + "}");
                out1.flush();
                break;
            case "delete":
                //获取表单数据id，这是要删除的值
                idStr = req.getParameter("id");
                //将id转换为int类型
                id = Long.parseLong(idStr);
                System.out.println("delete id:"+id);
                //调用service层的delete方法
                orderService.delete(id);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out2 = resp.getWriter();
                out2.write("{\"success\":" + true + "}");
                out2.flush();
                break;

            case "search":
                //获取填写的搜索字段
                idStr = req.getParameter("id");
                id = (idStr == null || idStr.isEmpty()) ? -1 : Long.parseLong(idStr); //如果为空则为-1
                String name = req.getParameter("name");
                name = (name != null && !name.isEmpty()) ? name : null; //如果为空则为null

                System.out.println("Search Params - ID: " + id + ", Name: " + name);//打印搜索字段

                List<Order> filteredOrders = orderService.search(id, name); //调用service层的search方法

                //将搜索结果转换为json再发送
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("data", filteredOrders); // Actual data array
                String searchJson = new Gson().toJson(responseMap);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(searchJson);
                break;
        }
    }
}
