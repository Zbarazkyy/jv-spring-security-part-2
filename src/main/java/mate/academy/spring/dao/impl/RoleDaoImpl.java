package mate.academy.spring.dao.impl;

import java.util.Optional;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        String query = "FROM Role "
                + "WHERE name = : roleName";
        try (Session session = factory.openSession()) {
            Query queryRoleByName = session.createQuery(query);
            queryRoleByName.setParameter("roleName", roleName);
            return queryRoleByName.uniqueResultOptional();
        }
    }
}