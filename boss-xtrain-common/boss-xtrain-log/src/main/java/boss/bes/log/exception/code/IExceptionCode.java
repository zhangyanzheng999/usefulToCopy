package boss.bes.log.exception.code;

/**
 * @description:所有实现IExceptionCode的类都可以用来传递参数
 * @author:zyz
 * @time:2020/6/30-20:32
 */
public interface IExceptionCode {

    /**
     * 拿到异常码
     * @return
     */
    String getCode();

    /**
     * 拿到异常消息
     * @return
     */
    String getMessage();
}
