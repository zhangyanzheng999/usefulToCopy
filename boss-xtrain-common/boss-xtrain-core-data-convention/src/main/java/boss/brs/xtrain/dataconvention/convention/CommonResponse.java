package boss.brs.xtrain.dataconvention.convention;

import boss.brs.xtrain.dataconvention.convention.head.ResponseHead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author XIONG
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CommonResponse<T> {
    @NotNull
    private T body;

    private ResponseHead head;
}
