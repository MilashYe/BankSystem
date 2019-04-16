package model.service.encryption;

public interface PasswordService {
	String createHash(String pwd);

	boolean checkPwd(String pwd, String dbHash);



}
