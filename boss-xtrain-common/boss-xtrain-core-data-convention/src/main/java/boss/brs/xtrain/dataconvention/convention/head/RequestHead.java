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
public class RequestHead{
    @Value("${head.version}")
    private String version;
    @Value("${head.token}")
    private String token;
    @Value("${head.number}")
    private String globalMessageNumber;
    private String serviceObject;
    private String deviceId;
    private Integer deviceType;
    private String operateSystemOrBrowser;
    private Integer encryptionType;
}
