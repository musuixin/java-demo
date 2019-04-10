package top.musuixin.PoJo;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * 用户表PoJo
 */


@Data
@Component
public class UserPoJo {
    String upwd;
    String email;
    String repwd;
}
