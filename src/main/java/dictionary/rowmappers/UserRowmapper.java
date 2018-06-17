package dictionary.rowmappers;

import dictionary.data.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowmapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int rownum) throws SQLException {
        User user = new User();
        user.setLogin(resultSet.getString("LOGIN"));
        user.setAdmin(resultSet.getBoolean("ISADMIN"));
        user.setFirstName(resultSet.getString("firstname"));
        user.setSurname(resultSet.getString("surname"));
        user.setPassword(resultSet.getString("PASSWORD"));
        user.setPesel(resultSet.getString("PESEL"));
        user.setRegisterDate(resultSet.getTimestamp("REGISTERDATE"));
        return user;
    }
}
