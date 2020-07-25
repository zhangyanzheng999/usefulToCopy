package boss.brs.xtrain.dataconvention.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @class BaseDTO
 * @classdesc 考虑DTO从这里继承便于统一DTO接口和转型判断
 *
 * @author Administrator
 * @date 2020-07-01 20:39
 * @version 1.0.0
 * @see
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDTO implements Serializable {
    /**
     *  主键
     */
    @Id
    private Long id;

    private Byte status;

    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    private Long createdBy;
    /**
     *  更新时间记录便于追踪
     */
    private Date updatedTime;
    /**
     *  更新人ID 后续的update更新此字典
     */
    private Long updatedBy;
    /**
     *  当前行的版初始为0 每次数据变动则加1
     */
    private Long version;

}
