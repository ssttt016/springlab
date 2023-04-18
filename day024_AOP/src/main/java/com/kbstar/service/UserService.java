package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("uservice")
public class UserService implements MyService<String, UserDTO> {

    @Autowired
    UserDAO dao;  // 인터페이스 사용이 아닌 그냥 바로 엮기

    //    @Qualifier("udao")
//    MyDao<String, UserDTO> dao;
    @Override
    public void register(UserDTO userDTO) {
        dao.insert(userDTO);
        System.out.println("Send Mail");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
    }

    @Override
    public void modify(UserDTO UserDTO) {
        dao.update(UserDTO);
        System.out.println("Send Mail ..");


    }

    @Override
    public UserDTO get(String s) {
        return dao.select(s);
    }

    @Override
    public List<UserDTO> get() {
        return dao.select();
    }
}