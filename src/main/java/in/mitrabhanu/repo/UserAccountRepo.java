package in.mitrabhanu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.mitrabhanu.model.UserAccount;
import jakarta.transaction.Transactional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Modifying
	@Transactional
	@Query("update UserAccount set activeSw=:status where userId=:userId")
	public void updateUserAccStatus(@Param("userId")Integer userId, @Param("status")String status);
}
