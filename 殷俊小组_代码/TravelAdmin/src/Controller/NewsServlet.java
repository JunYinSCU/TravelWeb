package Controller;

import Service.NewsService;
import Service.ProductService;
import Service.TravelService;
import com.google.gson.Gson;
import entity.News;
import entity.Product;
import entity.Travel;


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

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService = new NewsService();

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
                List<News> travelList = newsService.list();
                // 将产品列表转为json存入request域
                Gson gson = new Gson();
                String json = gson.toJson(travelList);
                //返回数据
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);//将json数据返回
                break;

            case "save":
                // 获取表单数据
                String title = req.getParameter("title");
                String introduction = req.getParameter("introduction");
                String content = req.getParameter("content");


                //打印获取到的表单数据到控制台
                System.out.println("add title: "+title);
                System.out.println("add introduction: "+introduction);
                System.out.println("add content: "+content);

                // 创建产品对象并保存
                News news = new News(title, introduction, content);

                //这里有try catch是因为dao层用了日期转换，所以要处理异常
                //如果你的方法没有抛出异常，可以不用try catch，直接调用service层的save方法
                try {
                    // 调用service层的save方法保存产品
                    newsService.save(news);
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
                int id = Integer.parseInt(idStr);
                title = req.getParameter("title");
                introduction = req.getParameter("introduction");
                content = req.getParameter("content");

                System.out.println("update id:" + id);
                System.out.println("update title: "+title);
                System.out.println("update introduction: "+introduction);
                System.out.println("update content: "+content);

                //创建product对象
                news = new News(id, title, introduction, content);
                //调用service层的update方法
                newsService.update(news);
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
                id = Integer.parseInt(idStr);
                System.out.println("delete id:"+id);
                //调用service层的delete方法
                newsService.delete(id);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out2 = resp.getWriter();
                out2.write("{\"success\":" + true + "}");
                out2.flush();
                break;

            /*case "search":
                //获取填写的搜索字段
                *//*idStr = req.getParameter("id");
                id = (idStr == null || idStr.isEmpty()) ? -1 : Integer.parseInt(idStr); //如果为空则为-1*//*
                String name = req.getParameter("name");
                name = (name != null && !name.isEmpty()) ? name : null; //如果为空则为null

                System.out.println("Search Params - Name: " + name);//打印搜索字段

                List<Travel> filteredProducts = newsService.search(name); //调用service层的search方法

                //将搜索结果转换为json再发送
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("data", filteredProducts); // Actual data array
                String searchJson = new Gson().toJson(responseMap);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(searchJson);
                break;*/
        }
    }
}
