package test.ws.ws.persistence.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class IdEntity implements Serializable {
	
	private static final long serialVersionUID = 3953977144749349775L;
	/**
	 * The ID attribute.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * <p>
	 * Returns current value of id attribute.
	 * </p>
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * <p>
	 * Sets value of id attribute.
	 * </p>
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}