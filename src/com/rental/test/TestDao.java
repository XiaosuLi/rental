import com.rental.mapper.UserMapper;
import com.rental.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resources/applicationContext.xml")
public class TestDao {

    @Autowired
     private UserMapper userMapper;

    @Test
    public void testList(){
        List<User> users = userMapper.listAllUser();
        for(User u : users){
            System.out.println("�û�id��"+u.getUserId()+
                               "�û�������"+u.getUserName()+
                               "�û��绰��"+u.getUserPhone()+
                               "�û����룺"+u.getUserPassword()
            );
        }
    }

    @Test
    public  void testRes(){
      //  User xiaosu = new User("13412345678","С����","1234560");
      //  userMapper.userRegister(xiaosu);
    }

    @Test
    public  void  testUserIsExist(){
        String phone = "12312345678";
        User u = userMapper.userIsExist(phone);

        if(u == null){
            System.out.println("�û�������");
        }else {
            System.out.println("�û�����");
        }
    }

    @Test
    public  void testUserLogin(){
        String userPhone = "13437152430";

        userMapper.userChangePawd(userPhone,"6666666");


    }
}
