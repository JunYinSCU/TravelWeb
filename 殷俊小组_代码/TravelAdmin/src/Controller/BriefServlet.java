package Controller;

import Service.BriefService;
import Service.ProductService;
import com.google.gson.Gson;
import entity.Brief;
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

@WebServlet("/brief")
public class BriefServlet extends HttpServlet {
    private BriefService briefService = new BriefService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
                //获取表单数据
                String text = req.getParameter("brief");

                System.out.println("update text: "+ text);

                //创建product对象
                Brief brief = new Brief(1, text);
                //调用service层的update方法
                briefService.update(brief);
                //返回结果
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out1 = resp.getWriter();
                out1.write("{\"success\":" + true + "}");
                out1.flush();
    }
}
