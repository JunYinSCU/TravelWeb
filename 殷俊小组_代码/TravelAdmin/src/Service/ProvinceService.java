package Service;

import Dao.ProvinceDao;
import entity.Province;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class ProvinceService
{

    private ProvinceDao provinceDao = new ProvinceDao();



    public List<Province> list() {
        //直接调用Dao层的list方法
        return this.provinceDao.list();
    }

    public void save(Province province) throws ParseException
    {
        //直接调用Dao层的save方法
        Integer save = this.provinceDao.save(province);
        if(save != 1) throw new RuntimeException("添加失败");
    }


    public void update(Province province) {
        //直接调用Dao层的update方法
        Integer update = this.provinceDao.update(province);

        if(update != 1) throw new RuntimeException("更新学生信息失败");
    }


    public void delete(String shiqu) {
        //直接调用Dao层的delete方法
        Integer delete = this.provinceDao.delete(shiqu);
        if(delete != 1) throw new RuntimeException("删除学生信息失败");
    }

    public List<Province> search(int id, String shenqgu) {

        List<Province> countries = this.list();//这是整个province list
        List<Province> result = null;//这是要返回的list

        if(id == -1 && shenqgu == null) //id和name都为空，返回所有list
        {
            result = countries;
        }
        else if(id == -1) //id为空，name不为空，返回name匹配的list
        {
            result = countries.stream() //countries该为你的实体类list
                    .filter(Province -> Province.getProvinceName().contains(shenqgu))  //看不懂没关系，照着改这一行就行了，province改成你的实体类，getJingdianmingcheng()改为你自己的获取方法，name就是传进来的参数name
                    .collect(Collectors.toList());

        }

        return result; //返回结果list
    }
}
