package core.api.DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import core.api.DTO.UserDTO;
import core.api.entities.User;
import core.api.interfaces.UserDAO;
import core.config.HibernateFactory;

public class UserDBDAO implements UserDAO{

	Session session = null;
	
	@Override
	public void openConnection() {
		SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
		this.session = sessionFactory.openSession();
	}

	@Override
	public void closeConnection() {
		if(session != null)
			session.close();
	}

	@Override
	public UserDTO getUserByName(String username) {

		UserDTO userDTO = null;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		criteria.where(cb.equal(root.get("Email"),username));
		
		Query<User> query  = session.createQuery(criteria);
		List<User> list = query.getResultList();
		if(list !=null && list.size() > 0) {
			User user = list.get(0);
			BeanUtils.copyProperties(user, userDTO);
		}
		
		return userDTO;
	}

	@Override
	public UserDTO saveUser(UserDTO user) {
		UserDTO returnValue = null;
		
		User userEntity = new User();
		BeanUtils.copyProperties(user, userEntity);
		
		session.beginTransaction();
		session.save(userEntity);
		session.getTransaction().commit();
		
		returnValue = new UserDTO();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

}
