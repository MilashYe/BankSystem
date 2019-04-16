package model.dao.impl.jdbc.mysql;

public interface SQLQueries {
	String CREATE_USER = "insert into user (login, role, pwdhash, name, surname, phone) VALUES (?,?,?,?,?,?) ";

	String READ_USER_BY_LOGIN = "select * from user " +
			"left join account_has_user on user.u_id = account_has_user.user_u_id " +
			"left join account on account_has_user.account_id_ac = account.id_ac " +
			"where user.login =(?)";

	String ADD_USER_AND_ACCOUNT = "insert into account_has_user (account_id_ac,user_u_id) values (?,?) ";

	String READ_USER_BY_ID = "select * from user " +
			"left join account_has_user on user.u_id = account_has_user.user_u_id " +
			"left join account on account_has_user.account_id_ac = account.id_ac " +
			"where user.u_id =(?)";

	String READ_ALL_USER = "select * from user " +
			"left join account_has_user on user.u_id = account_has_user.user_u_id " +
			"left join account on account_has_user.account_id_ac = account.id_ac";

	String DELETE_USER = "delete from user where login = (?)";

	String CREATE_ACCOUNT = "insert into account" +
			"(ac_money, closed) values (?,?);";
	String CREATE_TIME = "insert into time " +
			"(date,account_id_ac,mess) values (?,?,?);";

	String READ_ALL_ACCOUNT = "select * from account " +
			"left join account_has_user on account.id_ac = account_has_user.account_id_ac " +
			"left join user on account_has_user.user_u_id = user.u_id " +
			"left join credit on account.id_ac = credit.id_ac " +
			"left join deposit on account.id_ac = deposit.id_ac " +
			"left join time on account.id_ac = time.account_id_ac;";
	String READ_ACCOUNT_BY_ID = "select * from account " +
			"left join account_has_user on account.id_ac = account_has_user.account_id_ac " +
			"left join user on account_has_user.user_u_id = user.u_id " +
			"left join credit on account.id_ac = credit.id_ac " +
			"left join deposit on account.id_ac = deposit.id_ac " +
			"left join time on account.id_ac = time.account_id_ac " +
			"where account.id_ac = (?)";
	String UPDATE_ACOUNT_MONEY = "update account " +
			"set ac_money = (?), closed=(?) " +
			"where id_ac = (?);";
	String DELETE_ACCOUNT = "delete from account where id_ac = (?)";

    String CREATE_CREDIT = "insert into credit" +
			"(cred_money,cred_percent,cred_type,term_close,approved,rejected,id_ac) " +
			"values (?,?,?,?,?,?,?)";
	String READ_CREDIT_BY_ID = "select * from credit where id_cr=(?);";
	String DELETE_CREDIT = "delete from credit where id_cr = (?);" ;
	String UPDATE_CREDIT = "update credit " +
			"set cred_money=(?), term_close=(?), approved=(?), rejected=(?) " +
			"where id_cr = (?);";

    String CREATE_DEPOSIT = " insert into deposit " +
			"(id_ac,dep_money,dep_percent,dep_type,received_money,start_date,end_time) " +
			"values (?,?,?,?,?,?,?);";
	String DELETE_DEPOSIT = "delete from deposit where id_dep = (?);";
	String READ_DEPOSIT_BY_ID = "select * from deposit where id_dep=(?);";
	String UPDATE_DEPOSIT = "update deposit " +
			"set dep_money=(?), received_money=(?) " +
			"where id_dep = (?);";

    String READ_TIME_ALL = "select * from time;";
}
