package Service;

import Dao.CountryDao;
import entity.Country;


import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


public class CountryService
{

    private CountryDao countryDao = new CountryDao();



    public List<Country> list() {
        //直接调用Dao层的list方法
        return this.countryDao.list();
    }

    public void save(Country country) throws ParseException {
        //直接调用Dao层的save方法
        Integer save = this.countryDao.save(country);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(Country country) {
        //直接调用Dao层的update方法
        Integer update = this.countryDao.update(country);

        if(update != 1) throw new RuntimeException("更新学生信息失败");
    }


    public void delete(String shengqu) {
        //直接调用Dao层的delete方法
        Integer delete = this.countryDao.delete(shengqu);
        if(delete != 1) throw new RuntimeException("删除学生信息失败");
    }

    public List<Country> search(int id, String shenqgu) {

        List<Country> countries = this.list();//这是整个country list
        List<Country> result = null;//这是要返回的list

        if(id == -1 && shenqgu == null) //id和name都为空，返回所有list
        {
            result = countries;
        }
        else if(id == -1) //id为空，name不为空，返回name匹配的list
        {
            result = countries.stream() //countries该为你的实体类list
                    .filter(Country -> Country.getCountyName().contains(shenqgu))  //看不懂没关系，照着改这一行就行了，country改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }

        return result; //返回结果list
    }
}
