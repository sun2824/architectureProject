package com.sun2824.gatewayserver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class UserTable implements Serializable {
    @Id
    String userId;

    @Column
    String userName;

    @Column
    String password;

    @Column
    String email;

    @Column
    String authorities;

}
