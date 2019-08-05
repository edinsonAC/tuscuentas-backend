package com.backendtuscuentas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendtuscuentas.entitys.Checklist;

public interface ICheckListDao extends JpaRepository<Checklist, Long> {

}
