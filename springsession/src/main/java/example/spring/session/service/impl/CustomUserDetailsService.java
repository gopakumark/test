/**
 * 
 */
package example.spring.session.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.spring.session.dao.UserDao;
import example.spring.session.model.Role;
import example.spring.session.model.User;

/**
 * @author Neev
 *
 */
@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		List<GrantedAuthority> grantedAuthorities = buildGrantedAuthorities(user.getRoles());
		return buildUserForAuthentication(user,grantedAuthorities);
	}
	/**
	 * @param user
	 * @param grantedAuthorities
	 * @return
	 */
	private UserDetails buildUserForAuthentication(User user,
			List<GrantedAuthority> grantedAuthorities) {
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true, true, true, grantedAuthorities);
	}
	
	/**
	 * @return
	 */
	private List<GrantedAuthority> buildGrantedAuthorities(Set<Role> userRoles) {
		List<GrantedAuthority> grantedAuthorities = new LinkedList<GrantedAuthority>();
		for(Role role: userRoles){
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantedAuthorities;
	}

}
