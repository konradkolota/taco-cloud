package pl.kk.tacocloud.repositories;

import pl.kk.tacocloud.models.Order;

public interface OrderRepository {

    Order save(Order order);

}
