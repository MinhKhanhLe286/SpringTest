package com.javaweb.repository.entity;

public class BuildingEntity {
    private String name; // Thuộc tính private

    // Constructor không tham số (nếu không viết thì Java tự động tạo ra một constructor mặc định)

    // Getter cho thuộc tính name
    public String getName() {
        return name;
    }

    // Setter cho thuộc tính name
    public void setName(String name) {
        this.name = name;
    }
}
