package Service;

import Dao.NewsDao;
import Dao.ProductDao;
import Dao.TravelDao;
import entity.News;
import entity.Product;
import entity.Travel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NewsService {

    private NewsDao newsDao = new NewsDao();



    public List<News> list() {
        //直接调用Dao层的list方法
        return this.newsDao.list();
    }

    public void save(News news) throws ParseException {
        //直接调用Dao层的save方法
        Integer save = this.newsDao.save(news);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(News news) {
        //直接调用Dao层的update方法
        //获取当前时间
        news.setAddTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Integer update = this.newsDao.update(news);

        if(update != 1) throw new RuntimeException("更新信息失败");
    }


    public void delete(int id) {
        //直接调用Dao层的delete方法
        Integer delete = this.newsDao.delete(id);
        if(delete != 1) throw new RuntimeException("删除信息失败");
    }

    /*public List<News> search(String name) {

        List<News> travels = this.list();//这是整个product list
        List<News> result = null;//这是要返回的list

        if(name == null) //name为空，返回所有list
        {
            result = travels;
        }
        else //name不为空，返回name匹配的list
        {
            result = travels.stream() //products该为你的实体类list
                    .filter(travel -> travel.getYoukexingming().contains(name))  //看不懂没关系，照着改这一行就行了，product改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }

        return result; //返回结果list
    }*/


}
