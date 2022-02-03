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
public class MenuTable implements Serializable {

    @Id
    String fullPath;

    @Column
    String parentPath;

    @Column
    String childPath;

    @Column
    String authorities;

}
