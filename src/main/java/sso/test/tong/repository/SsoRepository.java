package sso.test.tong.repository;

import org.springframework.stereotype.Repository;
import sso.test.tong.entity.SsoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SsoRepository extends JpaRepository<SsoEntity, Long> {
}
