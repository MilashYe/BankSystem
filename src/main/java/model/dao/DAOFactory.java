package model.dao;

import model.dao.impl.jdbc.JDBCDaoFactory;
import model.dao.interfaces.*;

public abstract class DAOFactory {
	private static DAOFactory daoFactory;

	public abstract UserDAO createUserDAO();
	public abstract AccountDAO createAccountDAO();
	public abstract CreditDAO createCreditDAO();
	public abstract DepositDAO createDepositDAO();
	public abstract TimeDao createTimeDAO();


	public static DAOFactory getInstance(){
		if( daoFactory == null ){
			synchronized (DAOFactory.class){
				if(daoFactory==null){
					daoFactory = new JDBCDaoFactory();
				}
			}
		}
		return daoFactory;
	}

}
