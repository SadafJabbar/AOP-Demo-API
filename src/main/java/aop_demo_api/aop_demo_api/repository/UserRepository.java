package aop_demo_api.aop_demo_api.repository;

import aop_demo_api.aop_demo_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< UserEntity,Long> {
}
