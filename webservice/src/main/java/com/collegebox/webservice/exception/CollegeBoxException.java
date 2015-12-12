package com.collegebox.webservice.exception;

import javax.xml.ws.WebFault;

import com.collegebox.webservice.model.response.CollegeBoxExceptionResponse;

@WebFault(faultBean="com.collegebox.webserivce.exception.CollegeBoxException", 
	name="CtexcelException", targetNamespace="http://exception.webserivce.collegebox.com/")
public class CollegeBoxException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 1L;
	
	public final static int SystemBusy = -1;
	public final static int OK = 0;
	
	public final static int UsernameRequired = -40001;
	public final static int PasswordRequired = -40002;
	public final static int FirstNameRequired = -40003;
	public final static int LastNameRequired = -40004;
	public final static int NickNameRequired = -40005;
	public final static int EmailRequired = -40006;
	public final static int NameRequired = -40007;
	public final static int IdRequired = -40008;
	public final static int NewPasswordRequired = -40009;
	public final static int UrlRequired = -40010;
	public final static int TypeRequired = -40011;
	public final static int PathRequired = -40012;
	public final static int MarkRequired = -40013;
	
	public final static int UsernameInvalid = -50001;
	public final static int NameInvalid = -50002;
	public final static int PasswordInvalid = -50003;
	public final static int EmailInvalid = -50004;
	
	protected int code;
	
	protected CollegeBoxExceptionResponse faultInfo;
	
	public int getCode() {
		return code;
	}
	
	public CollegeBoxExceptionResponse getFaultInfo() {
		return faultInfo;
	}
	
	protected static String getMessage(int code) {
		switch (code) {
		case UsernameRequired:
			return "username required.";
		case PasswordRequired:
			return "password required.";
		case FirstNameRequired:
			return "first name required.";
		case LastNameRequired:
			return "last name required.";
		case NickNameRequired:
			return "nick name required.";
		case EmailRequired:
			return "email required.";
		case NameRequired:
			return "name required.";
		case IdRequired:
			return "id required.";
		case NewPasswordRequired:
			return "new password required.";
		case UrlRequired:
			return "url required.";
		case TypeRequired:
			return "type required.";
		case PathRequired:
			return "path required.";
		case MarkRequired:
			return "mark required.";
			
		case UsernameInvalid:
			return "username invalid.";
		case NameInvalid:
			return "name invalid.";
		case PasswordInvalid:
			return "password invalid.";
		case EmailInvalid:
			return "email invalid.";
			
		case SystemBusy:
			return "system busy.";
		default:
			return "system error.";
		}
	}
	
	public CollegeBoxException(int code) {
		super(getMessage(code));
		this.code = code;
		this.faultInfo = new CollegeBoxExceptionResponse(this);
	}

}
