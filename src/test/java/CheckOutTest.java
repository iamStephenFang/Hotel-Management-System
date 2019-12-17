import cn.edu.zjut.dao.CheckOutMapper;
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
public class CheckOutTest {
    private CheckOutMapper checkOutMapper = null;

    @Autowired
    public void setCheckOutMapper(CheckOutMapper checkOutMapper) {
        this.checkOutMapper = checkOutMapper;
    }
    public CheckOutMapper getCheckOutMapper() {
        return checkOutMapper;
    }


}
