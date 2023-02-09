package com.Luxifel.reggie.mbg.dao;

import com.Luxifel.reggie.mbg.model.AddressBook;

public interface AddressBookDao {
    int deleteByPrimaryKey(Long id);

    int insert(AddressBook record);

    int insertSelective(AddressBook record);

    AddressBook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AddressBook record);

    int updateByPrimaryKey(AddressBook record);
}