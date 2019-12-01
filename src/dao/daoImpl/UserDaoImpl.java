package dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.UserDao;
import model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User find(String userName, String password) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		
		String hql = "FROM User WHERE userName=? AND password=?";
		Query query = session.createQuery(hql);
		query.setString(0, userName);
		query.setString(1, password);
		
		List list = query.list();
				
		ts.commit();
		session.close();
		
		if (list.size()>0) {
			return (User) list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void save(User user) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		
		session.save(user);
		
		ts.commit();
		session.close();
	}

}
