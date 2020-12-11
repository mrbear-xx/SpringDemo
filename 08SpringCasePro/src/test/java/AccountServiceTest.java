import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.service.AccountService;

/**
 * 使用Junit单元测试：测试我们的配置
 * Spring整合junit的配置
 * 1.导入spring整合junit的jar（坐标）
 * 2.使用Junit提供的一个注解把原有的main方法替换成spring提供的
 *
 * @Runwith 3.告知spring的运行器，spring和ioc创建是基于注解的还是xml的，并且提供说明
 * @ContextConfiguration locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 * class：指定注解类所在地位置
 * 当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }
}
