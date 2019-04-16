package model.dao.impl.jdbc.mapper;

import model.entity.User;
import model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet set) throws SQLException {
        User user = new User();
        user.setId(set.getInt("u_id"));
        user.setLogin(set.getString("login"));
        user.setName(set.getString("name"));
        String role = set.getString("role");
        user.setRole(Role.valueOf(role==null?"guest".toUpperCase():role.toUpperCase()));
        user.setSurname(set.getString("surname"));
        user.setPhone(set.getString("phone"));
        user.setPwdHash(set.getString("pwdhash"));
        return user;
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }
}
