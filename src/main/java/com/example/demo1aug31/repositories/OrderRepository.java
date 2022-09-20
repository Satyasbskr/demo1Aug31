package com.example.demo1aug31.repositories;
import com.example.demo1aug31.entities.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Override
    List<Order> findAll();
    @Override
    Order save(Order order);
    @Override
    void deleteById(Long id);
    @Override
    Optional<Order> findById(Long id);

}
