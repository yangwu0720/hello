package cn.edu.zafu.subjectbuild.frame.exception;

/**
 * 自定义异常
 * @author cyk
 * @since 2019-06-06
 */
public class CustomException extends Exception {
	
	public CustomException() {
		super();
	}
	
	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message,Throwable throwable) {
		super(message, throwable);
	}
}
