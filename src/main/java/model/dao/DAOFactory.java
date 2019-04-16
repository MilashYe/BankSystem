package model.dao;

import model.dao.impl.jdbc.JDBCDaoFactory;
import model.dao.interfaces.AccountDAO;
import model.dao.interfaces.CreditDAO;
import model.dao.interfaces.DepositDAO;
import model.dao.interfaces.UserDAO;

public abstract class DAOFactory {
	private static DAOFactory daoFactory;

	public abstract UserDAO createUserDAO();
	public abstract AccountDAO createAccountDAO();
	public abstract CreditDAO createCreditDAO();
	public abstract DepositDAO createDepositDAO();


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
