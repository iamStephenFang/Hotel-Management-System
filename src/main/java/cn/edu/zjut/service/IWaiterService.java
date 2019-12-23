package cn.edu.zjut.service;

import cn.edu.zjut.po.Waiter;

public interface IWaiterService {
    boolean findAllWaiters();
    Waiter findById(Waiter waiter);
    boolean updateWaiter(Waiter waiter);
    boolean insertWaiter(Waiter waiter);
}
