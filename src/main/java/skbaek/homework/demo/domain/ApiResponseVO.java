package skbaek.homework.demo.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ApiResponseVO<T> {
	private String result = "OK";
	private String reason = "";
	private String status = "";
	private String title = "";
	private String name = "";
	private T data;


	public ApiResponseVO<T> setResultOK(T data) {
		result = "OK";
		
		if( reason.equals("") ) {
			reason = "Success";
		}
		
		this.data = data;
		return this;
	}
	
	public ApiResponseVO<T> setResultFAIL(T data) {
		result = "FAIL";
		
		if( reason.equals("") ) {
			reason = "Error";
		}
		
		this.data = data;
		return this;
	}

	public ApiResponseVO<T> setBankResultOK(String bankName, T data){
		result = "OK";

		if( reason.equals("") ) {
			reason = "Success";
		}
		this.name = bankName;
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "ApiResponseVO [result=" + result + ", reason=" + reason + ", data=" + data + "]";
	}
}