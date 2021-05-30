package kodlamaio.HRMSDB.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import kodlamaio.HRMSDB.entites.concretes.User;


public interface UserDao<T extends User> extends JpaRepository<T,Integer> {
      Optional<T> findByEmail(String email);
}
