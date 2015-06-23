/**
 * 
 */
package example.spring.session.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import example.spring.session.dao.UserDao;
import example.spring.session.model.User;

/**
 * @author Neev
 *
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see example.spring.session.dao.UserDao#findByUserName(java.lang.String)
	 */
	public User findByUserName(String username) {
		return (User) getSession().createCriteria(User.class).add(Restrictions.eq("name", username)).uniqueResult();
	}

}
