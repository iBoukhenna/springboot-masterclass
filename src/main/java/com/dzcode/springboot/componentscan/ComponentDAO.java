package com.dzcode.springboot.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentDAO {

    @Autowired
    ComponentJdbcConnection componentJdbcConnection;

    public ComponentJdbcConnection getJdbcConnection() {
        return componentJdbcConnection;
    }

    public void setComponentJdbcConnection(ComponentJdbcConnection componentJdbcConnection) {
        this.componentJdbcConnection = componentJdbcConnection;
    }
}