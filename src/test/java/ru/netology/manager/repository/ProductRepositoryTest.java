package ru.netology.manager.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Book;
import ru.netology.manager.domain.Product;
import ru.netology.manager.domain.TShirt;
import ru.netology.manager.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product item1 = new Book(1, "The Diary Of A Young Girl", 150, " Anne Frank");
    private Product item2 = new Book(2, "The Book Thief", 120, "Markus Zusak");
    private Product item3 = new TShirt(3, "Blue", 110, "Nike");
    private Product item4 = new TShirt(4, "Yellow", 700, "Reebok");

    @BeforeEach
    @Test
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    void shouldRemoveByExistedId() {
       repository.removeById(2);
       Product[] expected = {item1, item3, item4};
       Product[] actual = repository.findAll();
       assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotExistedId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(15));

    }




}
