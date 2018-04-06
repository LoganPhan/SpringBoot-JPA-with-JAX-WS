package test.ws.ws.persistence.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.ws.ws.persistence.model.IdEntity;

public interface IRepository<T extends IdEntity, ID extends Serializable>
		extends JpaRepository<T, ID>, RepositoryCustom<T, ID> {
}
