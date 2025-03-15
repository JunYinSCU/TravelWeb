package Service;

import Dao.BriefDao;
import Dao.ProductDao;
import entity.Brief;
import entity.Product;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class BriefService {

    private BriefDao briefDao = new BriefDao();

    public void update(Brief brief) {
        //直接调用Dao层的update方法
        Integer update = this.briefDao.update(brief);

        if(update != 1) throw new RuntimeException("更新间接信息失败");
    }


}
