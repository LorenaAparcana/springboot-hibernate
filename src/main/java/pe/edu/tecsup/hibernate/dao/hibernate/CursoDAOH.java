package pe.edu.tecsup.hibernate.dao.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;

@Repository
@Transactional
public class CursoDAOH extends BaseHibernateDAO implements CursoDAO{

    @Override
    public List<Curso> list() {

        Criteria criteria = this.getSession().createCriteria(Curso.class);
        return criteria.list();
    }

    @Override
    public Curso get(Long t) {
        Criteria criteria = this.getSession().createCriteria(Curso.class);
        criteria.add(Restrictions.eq("id", t));
        return (Curso) criteria.uniqueResult();
    }
    
   
    @Override
    public void save(Curso t) {
        this.getSession().save(t);
    }

    @Override
    public void update(Curso t) {
        this.getSession().merge(t);
    }

    @Override
    public void delete(Curso t) {
        this.getSession().delete(t);
    }

    
}
