package com.zc.milk.Service.impl;

import com.zc.milk.Service.MilkService;
import org.springframework.stereotype.Service;

@Service
public class MilkServiceImpl implements MilkService {

    public void apart(Integer index) {
        System.out.println("apart " + index);
    }
}
