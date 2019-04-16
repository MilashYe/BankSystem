package model.dao.impl.jdbc.mysql;

import model.dao.DAOFactory;
import model.dao.interfaces.UserDAO;
import model.entity.User;
import model.entity.enums.Role;
import model.service.encryption.JBCrypt;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JDBCUserDAOTest {
	private static UserDAO dao ;
	private static User testUser;

	@BeforeClass
	public static void init() {
		dao = DAOFactory.getInstance().createUserDAO();
		testUser = new User();
		testUser.setLogin("test");
		testUser.setName("Test");
		testUser.setSurname("Test");
		testUser.setPhone("+380000000000");
		testUser.setRole(Role.USER);
		testUser.setPwdHash(new JBCrypt().createHash("test"));


	}

	@Test
	public void create() {

		dao.create(testUser);
		User userFromDB = dao.readByLogin("test");
		dao.delete(testUser);
		assertEquals(testUser,userFromDB);



	}

	@Test
	public void readById() {
		dao.create(testUser);
		User userFromLogin = dao.readByLogin("test");
		User userById = dao.readById(userFromLogin.getId());
		dao.delete(testUser);
		assertEquals(testUser, userById);

	}

	@Test
	public void readByLogin() {
		User user = dao.readByLogin("admin");
		assertEquals("admin",user.getLogin() );
	}

	@Test
	public void readAll() {
		ArrayList<User> arrayList = (ArrayList<User>) dao.readAll();
		for (User u : arrayList) {
			System.out.println(u);
		}
	}
	@Test
	public void delete() {
		dao.create(testUser);
		dao.delete(testUser);
		System.out.println();
		assertNotEquals(testUser, dao.readByLogin(testUser.getLogin()));

	}
}