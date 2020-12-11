package spring.service;

import spring.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账
     * @param sourcename 转出账户名称
     * @param targetname 转入账户名称
     * @param money 转让金额
     */
    void transfer(String sourcename,String targetname,Float money);
}
