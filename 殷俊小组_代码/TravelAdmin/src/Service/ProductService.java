package Service;

import Dao.ProductDao;
import entity.Product;


import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductDao productDao = new ProductDao();



    public List<Product> list() {
        //直接调用Dao层的list方法
        return this.productDao.list();
    }

    public void save(Product product) throws ParseException {
        //直接调用Dao层的save方法
        Integer save = this.productDao.save(product);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(Product product) {
        //直接调用Dao层的update方法
        Integer update = this.productDao.update(product);

        if(update != 1) throw new RuntimeException("更新学生信息失败");
    }


    public void delete(Integer id) {
        //直接调用Dao层的delete方法
        Integer delete = this.productDao.delete(id);
        if(delete != 1) throw new RuntimeException("删除学生信息失败");
    }

    public List<Product> search(int id, String name) {

        List<Product> products = this.list();//这是整个product list
        List<Product> result = null;//这是要返回的list

        if(id == -1 && name == null) //id和name都为空，返回所有list
        {
            result = products;
        }
        else if(id == -1) //id为空，name不为空，返回name匹配的list
        {
            result = products.stream() //products该为你的实体类list
                    .filter(product -> product.getJingdianmingcheng().contains(name))  //看不懂没关系，照着改这一行就行了，product改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }
        else if(name == null || name.isEmpty()) //id不为空，name为空，返回id匹配的list
        {
            result = products.stream()//改法同上
                    .filter(product -> product.getId()==id)
                    .collect(Collectors.toList());
        }else //id和name都不为空，返回id和name都匹配的list
        {
            result = products.stream()//改法同上
                    .filter(product -> product.getId()==id && product.getJingdianmingcheng().contains(name))
                    .collect(Collectors.toList());
        }

        return result; //返回结果list
    }


}
