package com.sun2824.gatewayserver.repository;

import com.sun2824.gatewayserver.common.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTableRepository extends JpaRepository<UserTable, String> {
}
