package cn.edu.zjut.service;

import cn.edu.zjut.po.Waiter;

public interface IWaiterService {
    boolean findAllWaiters();
    boolean findById(Waiter waiter);
    boolean updateWaiter(Waiter waiter);
}
