package Service;

import Dao.OrderDao;
import Dao.ProductDao;
import entity.Order;
import entity.Product;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private OrderDao orderDao = new OrderDao();


    public List<Order> list() {
        //直接调用Dao层的list方法
        return this.orderDao.list();
    }

    public void save(Order order) throws ParseException {
        //直接调用Dao层的save方法
        Integer save = this.orderDao.save(order);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(Order order) {
        //直接调用Dao层的update方法
        Integer update = this.orderDao.update(order);

        if(update != 1) throw new RuntimeException("更新订单信息失败");
    }


    public void delete(Long id) {
        //直接调用Dao层的delete方法
        Integer delete = this.orderDao.delete(id);
        if(delete != 1) throw new RuntimeException("删除订单信息失败");
    }

    public List<Order> search(long id, String name) {

        List<Order> orders = this.list();//这是整个order list
        List<Order> result = null;//这是要返回的list

        if(id == -1 && name == null) //id和name都为空，返回所有list
        {
            result = orders;
        }
        else if(id == -1) //id为空，name不为空，返回name匹配的list
        {
            result = orders.stream() //products该为你的实体类list
                    .filter(order -> order.getYoukezhanghao().contains(name))  //看不懂没关系，照着改这一行就行了，product改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }
        else if(name == null || name.isEmpty()) //id不为空，name为空，返回id匹配的list
        {
            result = orders.stream()//改法同上
                    .filter(order -> order.getId()==id)
                    .collect(Collectors.toList());
        }else //id和name都不为空，返回id和name都匹配的list
        {
            result = orders.stream()//改法同上
                    .filter(order -> order.getId()==id && order.getYoukezhanghao().contains(name))
                    .collect(Collectors.toList());
        }

        return result; //返回结果list
    }


}
