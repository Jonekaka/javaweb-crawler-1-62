package cn.Learn_Java.jd.dao;

import cn.Learn_Java.jd.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item,Long> {
}
