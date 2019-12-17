import cn.edu.zjut.dao.CheckCustomerMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
@Rollback
public class CheckCustomerTest {
    private CheckCustomerMapper checkCustomerMapper = null;

    @Autowired
    public void setCheckCustomerMapper(CheckCustomerMapper checkCustomerMapper) {
        this.checkCustomerMapper = checkCustomerMapper;
    }
    public CheckCustomerMapper getCheckCustomerMapper() {
        return checkCustomerMapper;
    }


}
