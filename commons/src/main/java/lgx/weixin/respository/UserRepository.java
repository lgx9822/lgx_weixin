package lgx.weixin.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lgx.weixin.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	User findByOpenId(String openId);
	
}
