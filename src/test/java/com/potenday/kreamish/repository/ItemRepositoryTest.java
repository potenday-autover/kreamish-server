package com.potenday.kreamish.repository;

import com.potenday.kreamish.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void simpleSpringDataJpaTest() {
        //given
        String itemName = "item1";
        Item item = new Item();
        item.setName(itemName);

        itemRepository.save(item);

        //when
        Item findItem = itemRepository.findById(item.getItemId())
                .orElseThrow();

        //then
        assertThat(findItem.getName()).isEqualTo(itemName);
    }
}