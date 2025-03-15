package Service;

import Dao.LoginDao;

public class LoginService {
    private LoginDao loginDao=new LoginDao();

    public boolean[] adminLogin(String admin_name,String password){
        return loginDao.adminLogin(admin_name,password);
    }

    /*public boolean[] userLogin(String user_name,String password){
        return loginDao.userLogin(user_name,password);
    }*/
}
