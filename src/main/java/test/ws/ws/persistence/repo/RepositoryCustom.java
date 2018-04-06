package test.ws.ws.persistence.repo;

import java.io.Serializable;
import java.util.Collection;

import test.ws.ws.persistence.model.IdEntity;

public interface RepositoryCustom<T extends IdEntity, ID extends Serializable> {
	Collection<T> getAll();
	T getById(ID id);
	T create(T t);
	T update(T t);
	boolean doDelete(ID id);

}
