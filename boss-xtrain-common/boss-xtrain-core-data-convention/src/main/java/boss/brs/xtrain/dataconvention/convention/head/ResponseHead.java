package boss.brs.xtrain.dataconvention.convention.head;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author XIONG
 * 头部信息
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ResponseHead{
    @Value("${head.version}")
    String version;
    private String code;
    private String globalMessageNumber;
    private String serviceObject;
    private Integer flag;


}
