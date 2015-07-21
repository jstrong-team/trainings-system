package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Maria on 21.07.2015.
 */
@Entity
@Table(name = "subscibe")
public class Subscribe {
    @Id
    private int id;
    @Column
    private int employee_id;
}
