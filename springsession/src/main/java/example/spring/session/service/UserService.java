/**
 * 
 */
package example.spring.session.service;

import example.spring.session.model.User;

/**
 * @author Neev
 *
 */
public interface UserService {
	User findByUserName(String name);
}
