package Service;

import Dao.CityDao;
import entity.City;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class CityService
{

    private CityDao CityDao = new CityDao();



    public List<City> list() {
        //直接调用Dao层的list方法
        return this.CityDao.list();
    }

    public void save(City City) throws ParseException
    {
        //直接调用Dao层的save方法
        Integer save = this.CityDao.save(City);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(City City) {
        //直接调用Dao层的update方法
        Integer update = this.CityDao.update(City);

        if(update != 1) throw new RuntimeException("更新学生信息失败");
    }


    public void delete(String diqu) {
        //直接调用Dao层的delete方法
        Integer delete = this.CityDao.delete(diqu);
        if(delete != 1) throw new RuntimeException("删除学生信息失败");
    }

    public List<City> search(int id, String shenqgu) {

        List<City> countries = this.list();//这是整个City list
        List<City> result = null;//这是要返回的list

        if(id == -1 && shenqgu == null) //id和name都为空，返回所有list
        {
            result = countries;
        }
        else if(id == -1) //id为空，name不为空，返回name匹配的list
        {
            result = countries.stream() //countries该为你的实体类list
                    .filter(City -> City.getCityName().contains(shenqgu))  //看不懂没关系，照着改这一行就行了，City改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }

        return result; //返回结果list
    }
}
