package com.jeomo.flashSale.application.service.impl;

import com.jeomo.flashSale.application.service.OrderService;
import com.jeomo.flashSale.domain.entity.customer.Customer;
import com.jeomo.flashSale.domain.entity.flash.FlashSaleActivity;
import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.domain.repository.FlashSaleActivityRepository;
import com.jeomo.flashSale.domain.repository.OrderRepository;
import com.jeomo.flashSale.interfaces.dto.FlashSaleReqDto;
import com.jeomo.flashSale.redis.GoodsKey;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: qbt
 * @Date: 2020/3/20 18:32
 * @Version 1.0
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FlashSaleActivityRepository flashSaleActivityRepository;

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;



    @Override
    public Order flashSaling(FlashSaleReqDto dto) {
        Long customerId = dto.getCustomerId();
        Long goodsId = dto.getGoodsId();
        final GoodsKey goodsKey = GoodsKey.newMiaoShaStockKey(dto.getGoodsId());
//        final String lockValue = UUID.randomUUID().toString();
//        redisTemplate 第一种实现方式， 缺点是设置值和设置过期方式不在同一事物中，如果设置值成功，但是设置过期方式失败，则可能发生死锁。
//        boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(goodsKey.getKey(), lockValue);
//        stringRedisTemplate.expire(goodsKey.getKey(), goodsKey.getExpire(), goodsKey.getExpireTimeUnit());

//        redisTemplate 第二种实现方式， 将设置值和过期时间放在同一事务中， 避免了死锁的发生，但是可能会因为事务超时而发生错误。
//        boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(goodsKey.getKey(), lockValue, goodsKey.getExpire(), goodsKey.getExpireTimeUnit());
//        if(lock) {
//            try {
//                miaosha(dto);
//            } finally {
//                String cacheLockValue = (String) stringRedisTemplate.opsForValue().get(goodsKey.getKey());
//                if(lockValue.equals(cacheLockValue)) {
//                    stringRedisTemplate.delete(goodsKey.getKey());
//                }
//            }
//        }

        //使用redisson实现分布式事务锁， 避免了锁超时问题，
        //  但是1： 如果主从结构，在master上设置锁成功了，但是尚未同步到slave节点时，master节点挂了，也会出现超卖问题 解决方案：RedLock
        //  但是2：  单线程串行实现会有性能问题  解决方案： 使用分段锁，使不同段位落在不同的redis节点上
//        RLock lock = redissonClient.getLock(goodsKey.getKey());
//        lock.lock();
//        try {
//            return  miaosha(dto);
//        } finally {
//            lock.unlock();
//        }

        //使用RedLock实现分布式锁
        // Redlock 实现原理是，只有集群中半数以上的节点加锁成功，才算加锁成功。 如果加锁失败，则需要回滚
        // 缺点： 假如有5个节点ABCDE， 线程1 成功锁定了ABC 三个节点， 但是此时C节点挂了，导致C节点的数据没有来得及刷盘， 如果C节点重启，线程2又锁定了CDE三个节点，就会导致两个线程同时访问同一个共享资源。
        // 解决方法： 延时重启，即节点挂了以后，不要立即重启，而是稍过一段时间重启。
        RLock lock = redissonClient.getLock(goodsKey.getKey());
        RLock lock2 = redissonClient.getLock(goodsKey.getKey());
        RLock lock3 = redissonClient.getLock(goodsKey.getKey());
        RedissonRedLock redLock = new RedissonRedLock(lock, lock2, lock3);
        redLock.lock();
        try {
            return  miaosha(dto);
        } finally {
            redLock.unlock();
        }
    }


    private Order miaosha(FlashSaleReqDto dto) {
        Long customerId = dto.getCustomerId();
        Long goodsId = dto.getGoodsId();
        FlashSaleActivity activity = flashSaleActivityRepository.getById(dto.getActivityId());
        int result = flashSaleActivityRepository.flash(activity.getId(), dto.getGoodsId());
        if(result > 0) {
            System.out.println("顾客" + customerId + " 秒杀成功");
            Customer customer = new Customer(customerId);
            Order order = customer.flash(dto.getGoodsId());
            orderRepository.save(order);
            return order;
        }
        System.out.println("顾客" + customerId + " 秒杀失败");
        return null;
    }
}
