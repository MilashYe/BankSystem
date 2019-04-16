package model.service.encryption;

import org.mindrot.jbcrypt.BCrypt;

public class JBCrypt implements PasswordService {


	@Override
	public String createHash(String pwd) {
		return BCrypt.hashpw(pwd, BCrypt.gensalt(4));

	}

	@Override
	public boolean checkPwd(String pwd, String dbHash) {
		if(pwd==null||dbHash==null) {
			return false;
		}else {

			return BCrypt.checkpw(pwd, dbHash);
		}
	}


}
