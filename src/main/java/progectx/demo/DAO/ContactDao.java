package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {
}
