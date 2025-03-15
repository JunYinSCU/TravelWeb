package Controller;

import Service.ProductService;
import com.google.gson.Gson;
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

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

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
                List<Product> productList = productService.list();
                // 将产品列表转为json存入request域
                Gson gson = new Gson();
                String json = gson.toJson(productList);
                //返回数据
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);//将json数据返回
                break;

            case "save":
                // 获取表单数据
                String jingdianmingcheng = req.getParameter("jingdianmingcheng");
                String jingdiandengji = req.getParameter("jingdiandengji");
                String jingdianjieshao = req.getParameter("jingdianjieshao");
                String suozaishengqu = req.getParameter("suozaishengqu");
                String suozaishiqu = req.getParameter("suozaishiqu");
                String suozaidiqu = req.getParameter("suozaidiqu");
                String meitiankaifangshijian = req.getParameter("meitiankaifangshijian");
                String meitianguanbishijian = req.getParameter("meitianguanbishijian");
                String beizhu = req.getParameter("beizhu");
                String jiage = req.getParameter("jiage");

                //打印获取到的表单数据到控制台
                System.out.println("add jingdianmingcheng: "+jingdianmingcheng);
                System.out.println("add jingdiandengji: "+jingdiandengji);
                System.out.println("add jingdianjieshao: "+jingdianjieshao);
                System.out.println("add suozaishengqu: "+suozaishengqu);
                System.out.println("add suozaishiqu: "+suozaishiqu);
                System.out.println("add suozaidiqu: "+suozaidiqu);
                System.out.println("add meitiankaifangshijian: "+meitiankaifangshijian);
                System.out.println("add meitianguanbishijian: "+meitianguanbishijian);
                System.out.println("add beizhu: "+beizhu);
                System.out.println("add jiage: "+jiage);

                // 创建产品对象并保存
                Product product = new Product(1,jingdianmingcheng, jingdiandengji, jingdianjieshao,
                        suozaishengqu, suozaishiqu, suozaidiqu,
                        meitiankaifangshijian, meitianguanbishijian,
                        beizhu, jiage);

                //这里有try catch是因为dao层用了日期转换，所以要处理异常
                //如果你的方法没有抛出异常，可以不用try catch，直接调用service层的save方法
                try {
                    // 调用service层的save方法保存产品
                    productService.save(product);
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
                jingdianmingcheng = req.getParameter("jingdianmingcheng");
                jingdiandengji = req.getParameter("jingdiandengji");
                jingdianjieshao = req.getParameter("jingdianjieshao");
                suozaishengqu = req.getParameter("suozaishengqu");
                suozaishiqu = req.getParameter("suozaishiqu");
                suozaidiqu = req.getParameter("suozaidiqu");
                meitiankaifangshijian = req.getParameter("meitiankaifangshijian");
                meitianguanbishijian = req.getParameter("meitianguanbishijian");
                beizhu = req.getParameter("beizhu");
                jiage = req.getParameter("jiage");

                System.out.println("update id:" + id);
                System.out.println("update jingdianmingcheng: "+jingdianmingcheng);
                System.out.println("update jingdiandengji: "+jingdiandengji);
                System.out.println("update jingdianjieshao: "+jingdianjieshao);
                System.out.println("update suozaishengqu: "+suozaishengqu);
                System.out.println("update suozaishiqu: "+suozaishiqu);
                System.out.println("update suozaidiqu: "+suozaidiqu);
                System.out.println("update meitiankaifangshijian: "+meitiankaifangshijian);
                System.out.println("update meitianguanbishijian: "+meitianguanbishijian);
                System.out.println("update beizhu: "+beizhu);
                System.out.println("update jiage: "+jiage);
                //创建product对象
                product = new Product(id,jingdianmingcheng, jingdiandengji, jingdianjieshao,
                        suozaishengqu, suozaishiqu, suozaidiqu,
                        meitiankaifangshijian, meitianguanbishijian,
                        beizhu, jiage);
                //调用service层的update方法
                productService.update(product);
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
                productService.delete(id);
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
                    id = (idStr == null || idStr.isEmpty()) ? -1 : Integer.parseInt(idStr); //如果为空则为-1
                    String name = req.getParameter("name");
                    name = (name != null && !name.isEmpty()) ? name : null; //如果为空则为null

                    System.out.println("Search Params - ID: " + id + ", Name: " + name);//打印搜索字段

                    List<Product> filteredProducts = productService.search(id, name); //调用service层的search方法

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
