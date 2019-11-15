package utils.response;

/**
 * 错误码和错误信息定义类
 * 1. 错误码定义规则为5为数字
 * 2. 前两位表示服务，最后三位表示错误码。例如：100001。10表示用户服务 001代表账号或密码错误
 * 3. 维护错误码后需要维护错误描述
 * 错误码列表：
 *  10: 用户服务
 *      001：账号或密码错误
 *  11：订单服务
 *      001：单据不存在
 */
public class ResponseConstants {

    public static final String SUCCESS_CODE = "00000";

    public static final String SUCCESS_MSG = "请求成功";

    public static final String FAILURE_CODE = "99999";

    public static final String FAILURE_MSG = "请求失败";




}
