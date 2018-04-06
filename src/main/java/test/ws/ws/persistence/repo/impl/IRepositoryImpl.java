package test.ws.ws.persistence.repo.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.ws.ws.persistence.model.IdEntity;
import test.ws.ws.persistence.repo.IRepository;
/**
 * <p>
 * The abstract repository which implements common APIs of a repository.
 * </p>
 * 
 * @author LoganPhan
 * @see {@link Repository}
 */
@NoRepositoryBean
@Transactional
public class IRepositoryImpl<T extends IdEntity, ID extends Serializable> implements IRepository<T, ID> {
	private static final Logger LOGGER = LoggerFactory.getLogger(IRepositoryImpl.class);
	 /**
     * The {@link EntityManager}.
     */
	@PersistenceContext
    protected EntityManager entityManager;    
    /**
     * <p>Sets value of entityManager attribute.</p>
     *
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    /**
     * <p>Returns current value of entityManager attribute.</p>
     *
     * @return the entityManager
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    /**
     * The internal repository.
     * @see SimpleJpaRepository
     */
    protected SimpleJpaRepository<T, ID> repository;
    /**
     * <p>Initialize.</p>
     */
    @SuppressWarnings("unchecked")
    @PostConstruct
    protected final void init() {
    	LOGGER.debug("Begin Init Method");
        try {
            final ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
            final Class<T> domainClass = (Class<T>) superclass.getActualTypeArguments()[0];
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initialize repository for domain: " + domainClass);
            }
            //entityManager = entityManager.getEntityManagerFactory().createEntityManager();
            final JpaEntityInformation<T, ID> entityInfo = (JpaEntityInformation<T, ID>)
                    JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
            repository = new SimpleJpaRepository<T, ID>(entityInfo, entityManager);
        } finally {	
            LOGGER.debug("End Method");
        }
    }
    
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return null;
	}

	@Override
	public List<T> findAll(Iterable<ID> ids) {
		return null;
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public T getOne(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> S save(S entity) {
		return null;
	}

	@Override
	public T findOne(ID id) {
		return repository.findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(ID id) {
		repository.delete(id);
	}

	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public <S extends T> S findOne(Example<S> example) {
		return null;
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends T> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public Collection<T> getAll() {
		Collection<T> list = null;
		try {
			 list = findAll();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.JpaRepository#findOne()
     */
	@Override
	public T getById(ID id) {
		return findOne(id);
	}

	@Override
	public T create(T t) {
		return saveAndFlush(t);
	}

	@Override
	public T update(T t) {
		return saveAndFlush(t);
	}

	@Override
	public boolean doDelete(ID id) {
		delete(id);
		if(findOne(id)==null) {
			return true;
		}
		return false;
	}
}
