package kosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.model.ItemDao;
import kosta.model.Order;
import kosta.model.OrderDao;

@Service
public class OrderService {
	
	private OrderDao orderDao;
	private ItemDao itemDao;
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	//propagation = transaction 단위
	@Transactional(propagation=Propagation.REQUIRED,
			rollbackFor={Exception.class})
	public void orderAction(Order order) throws Exception {
		//주문
		orderDao.addOrder(order);//주문처리
		
		if(itemDao.findItem(order.getNo()).getAmount() < order.getAmount()) {
			throw new Exception();
		}
		
		itemDao.updateItem(order); //재고수량 조정
		
		
	}
	
}
