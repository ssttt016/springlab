package com.kbstar.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Search;
import com.kbstar.dto.Search2;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.CustMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class CustService implements KBService<String, Cust> {

    @Autowired
    CustMapper mapper;
    @Override
    public void register(Cust cust) throws Exception {
        mapper.insert(cust);
        //mapper.insert(cust);
        log.info("Send Mail .........."+cust.getId());
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Cust cust) throws Exception {
        mapper.update(cust);
    }

    @Override
    public Cust get(String s) throws Exception {
        return mapper.select(s);
    }
    @Override
    public List<Cust> get() throws Exception {
        return mapper.selectall();
    }

    public Page<Cust> getPage(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 3);
        return mapper.getpage();
    }
    public Page<Cust> getFindPage(int pageNo, Search search) throws Exception {
        PageHelper.startPage(pageNo, 2);
        return mapper.getfindpage(search);
    }
    public Page<Cust> getFindPage2(int pageNo, Search2 search2) throws Exception {
        PageHelper.startPage(pageNo, 3);
        return mapper.getfindpage2(search2);
    }
}
