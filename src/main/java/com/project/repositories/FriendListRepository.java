package com.project.repositories;

import com.project.models.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendListRepository extends JpaRepository<FriendList, Long> {
    List<FriendList> findAllByStatus(String status);
}
