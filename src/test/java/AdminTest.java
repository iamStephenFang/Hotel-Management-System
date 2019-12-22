import cn.edu.zjut.dao.AdminMapper;
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
public class AdminTest {
    private AdminMapper adminMapper = null;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper){};
    public AdminMapper getAdminMapper() {
        return adminMapper;
    }
}
