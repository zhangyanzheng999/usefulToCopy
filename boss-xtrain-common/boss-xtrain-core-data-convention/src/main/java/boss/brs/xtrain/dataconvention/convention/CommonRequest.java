package boss.brs.xtrain.dataconvention.convention;

import boss.brs.xtrain.dataconvention.convention.head.RequestHead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @param
 * @author: Administrator
 * @since
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CommonRequest<T> {
    @NotNull
    private T body;

    private RequestHead head;

}
