/**
 * 
 */
package example.spring.session.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Neev
 *
 */
@Entity
@Table(name="Roles")
public class Role {
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	@Column
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
