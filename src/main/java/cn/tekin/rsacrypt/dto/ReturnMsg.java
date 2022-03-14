package cn.tekin.rsacrypt.dto;

import lombok.Data;
import java.io.Serializable;

/***
 * JSON数据返回对象封装!
 * @author Tekin
 *
 */
@Data
public class ReturnMsg  implements Serializable {

	private static final long serialVersionUID = 1L;
	/**  错误代码：0为执行成功，-1为执行失败 */
	private long code=-1;//默认失败

	/**  当code为-1时，errorMsg要填写失败的信息提示 */
	private String msg="Failure";//默认失败

	/** 需要返回的数据OBJ */
	private Object data=null;//默认null

	/** 构造*/
	public ReturnMsg(){}
	public ReturnMsg(long code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ReturnMsg(long code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
