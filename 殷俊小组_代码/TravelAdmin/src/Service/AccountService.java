package Service;

import Dao.AccountDao;
import entity.Account;
import entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private AccountDao accountDao=new AccountDao();

    public List<Account> list(){
        //直接调用Dao层的list方法
        return this.accountDao.list();
    }

    public void ban(Long id,int bantype,String banreason){
        Integer ban=this.accountDao.ban(id,bantype,banreason);
        //System.out.println("调用了Service的ban\n");
        if(ban!=1){throw new RuntimeException("封禁账号失败");}
    }

    public void unban(Long id){
        Integer unban=this.accountDao.unban(id);
        if(unban!=1){throw new RuntimeException("解封账号失败");}
    }

    public List<Account> search(Long id, String youkezhanghao, String youxiang){
        List<Account> accounts = this.list();
        return accounts.stream()
                // 当id不为-1时，进行id的过滤
                .filter(account -> id == -1 || account.getId() == id)
                // 当youkezhanghao不为空时，进行youkezhanghao的过滤
                .filter(account -> youkezhanghao == null || youkezhanghao.isEmpty() || account.getYoukezhanghao().contains(youkezhanghao))
                // 当youxiang不为空时，进行youxiang的过滤
                .filter(account -> youxiang == null || youxiang.isEmpty() || account.getYouxiang().contains(youxiang))
                .collect(Collectors.toList());  // 收集结果为List
    }

    public boolean checkBan(String youkezhanghao){  //调用accountDao的checkBan
        System.out.println("调用了AccountService的checkBan");
        System.out.println(accountDao.checkBan(youkezhanghao));
        return this.accountDao.checkBan(youkezhanghao);
    }

    public void reset(Long id){
        Integer ban=this.accountDao.reset(id);
        //System.out.println("调用了Service的reset\n");
        if(ban!=1){throw new RuntimeException("重置密码失败");}
    }
}
