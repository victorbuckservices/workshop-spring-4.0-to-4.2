package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.domain.User;

/**
 * Created by nlabrot on 02/09/15.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
