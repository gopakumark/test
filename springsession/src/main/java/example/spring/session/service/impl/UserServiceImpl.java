/**
 * 
 */
package example.spring.session.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.session.dao.UserDao;
import example.spring.session.model.User;
import example.spring.session.service.UserService;

/**
 * @author Neev
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private	UserDao dao;
	/* (non-Javadoc)
	 * @see example.spring.session.service.UserService#findByUserName(java.lang.String)
	 */
	public User findByUserName(String name) {
		return dao.findByUserName(name);
	}

}
