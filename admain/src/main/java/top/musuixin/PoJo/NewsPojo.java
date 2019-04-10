package top.musuixin.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-01 09:48
 *
 * 数据库新闻表映射
 */
@Data
@Component
public class NewsPojo {
      private long id;
      private String title;
      private String frontCover;
      private String date;
      private String author;
      private String text;
      private String plate;

}
