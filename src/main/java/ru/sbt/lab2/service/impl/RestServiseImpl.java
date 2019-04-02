package ru.sbt.lab2.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sbt.lab2.domain.entity.User;
import ru.sbt.lab2.domain.entity.User_;
import ru.sbt.lab2.model.data.DataWrapper;
import ru.sbt.lab2.model.report.UserInfoReport;
import ru.sbt.lab2.service.RestService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class RestServiseImpl implements RestService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public DataWrapper getUserInfo(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserInfoReport> criteriaQuery = builder.createQuery(UserInfoReport.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(
                builder.construct(
                        UserInfoReport.class,
                        root.get(User_.id),
                        root.get(User_.login)
                )
        );
        if (id != null) {
            List<Predicate> predicates = Collections.singletonList(
                    builder.equal(root.get(User_.id), id)
            );
            criteriaQuery.where(builder.and(predicates.toArray(new Predicate[]{})));
        }
        criteriaQuery.orderBy(builder.asc(root.get(User_.login)));
        Query query = em.createQuery(criteriaQuery);
        List<UserInfoReport> reports = query.getResultList();
        return new DataWrapper(reports);
    }
}
