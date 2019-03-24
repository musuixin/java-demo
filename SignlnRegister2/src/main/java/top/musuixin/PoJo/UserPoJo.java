package top.musuixin.PoJo;


import lombok.Data;
import org.springframework.stereotype.Component;
import top.musuixin.Util.EncryptUtil;

/**
 *
 * 用户表PoJo
 */


@Data
@Component
public class UserPoJo {
    int id;
    String uname;
    String upwd;
    String email;
}
