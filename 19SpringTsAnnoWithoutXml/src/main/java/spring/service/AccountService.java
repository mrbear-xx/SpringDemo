package spring.service;

import spring.entity.Account;

public interface AccountService {

    /**
     * 根据id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param source
     * @param targetName
     * @param monty
     */
    void transfer(String source,String targetName,Float monty);

}
