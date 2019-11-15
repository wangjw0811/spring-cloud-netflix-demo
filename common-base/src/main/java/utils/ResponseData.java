package utils;

import lombok.Data;
import utils.response.ResponseConstants;

import java.io.Serializable;

@Data
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = -820511581645221095L;
    /**
     * 返回码
     */
    private String resultCode;

    /**
     * 返回信息
     */
    private String resultMsg;

    /**
     * 返回数据
     */
    private Object data;

    public  ResponseData(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResponseData(String resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public static <T> ResponseData<T> success(){
        return success(null);
    }

    public static <T> ResponseData<T> success(Object data){
        return success(ResponseConstants.SUCCESS_CODE, data);
    }

    public static <T> ResponseData<T> success(String resultCode, Object data){
        return success(resultCode, ResponseConstants.SUCCESS_MSG, data);
    }

    public static <T> ResponseData<T> success (String resultCode, String resultMsg, Object data){
        return new ResponseData(resultCode, resultMsg, data);
    }

    public static <T> ResponseData<T> failure(){
        return failure(ResponseConstants.FAILURE_MSG);
    }

    public static <T> ResponseData<T> failure(String resultMsg){
        return failure(ResponseConstants.FAILURE_CODE, resultMsg);
    }

    public static <T> ResponseData<T> failure(String resultCode, String resultMsg){
        return new ResponseData(resultCode, resultMsg);
    }


}
