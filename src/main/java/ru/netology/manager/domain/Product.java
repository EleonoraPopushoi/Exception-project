package ru.netology.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Product {
    private int Id;
    private String name;
    private int price;

    public boolean matches(String search) {
        if (this.getName().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
