package Service;

import Dao.TravelDao;
import entity.Travel;


import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class TravelService {

    private TravelDao travelDao = new TravelDao();



    public List<Travel> list() {
        //直接调用Dao层的list方法
        return this.travelDao.list();
    }

    public void save(Travel travel) throws ParseException {
        //直接调用Dao层的save方法
        Integer save = this.travelDao.save(travel);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(Travel travel) {
        //直接调用Dao层的update方法
        Integer update = this.travelDao.update(travel);

        if(update != 1) throw new RuntimeException("更新信息失败");
    }


    public void delete(Integer id) {
        //直接调用Dao层的delete方法
        Integer delete = this.travelDao.delete(id);
        if(delete != 1) throw new RuntimeException("删除信息失败");
    }

    public List<Travel> search(String name) {

        List<Travel> travels = this.list();//这是整个product list
        List<Travel> result = null;//这是要返回的list

        if(name == null) //name为空，返回所有list
        {
            result = travels;
        }
        else //name不为空，返回name匹配的list
        {
            result = travels.stream() //products该为你的实体类list
                    .filter(travel -> travel.getTravelTime().contains(name))  //看不懂没关系，照着改这一行就行了，product改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }

        return result; //返回结果list
    }


}
