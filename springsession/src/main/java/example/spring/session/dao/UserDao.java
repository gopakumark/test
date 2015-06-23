/**
 * 
 */
package example.spring.session.dao;

import example.spring.session.model.User;

/**
 * @author Neev
 *
 */
public interface UserDao {
	User findByUserName(String username);
}
