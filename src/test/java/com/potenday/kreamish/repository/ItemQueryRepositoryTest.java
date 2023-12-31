package com.potenday.kreamish.repository;

import com.potenday.kreamish.item.entity.Item;
import com.potenday.kreamish.item.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemQueryRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Test
    void simpleQueryDslSelectTest(){
        String item1Name = "item1";
        String item2Name = "item2";

        //given
        Item item1 = new Item();
        item1.setName(item1Name);

        Item item2 = new Item();
        item2.setName(item2Name);

        //when
        em.persist(item1);
        em.persist(item2);
        em.flush();
        em.clear();

        //then
        List<Item> findItems = repository.findItemsWhereLikes(item1Name);
        assertThat(findItems).isNotNull();
        assertThat(findItems.size()).isEqualTo(1);
        assertThat(findItems.get(0).getName()).isEqualTo(item1Name);
    }
}