package top.musuixin.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class InfoPolo {
	String ID;
    String Name;
    String Education;
    String Skill;
    String IdealPost;
    String WorkExperience;
    String ExpectantCity;
}
