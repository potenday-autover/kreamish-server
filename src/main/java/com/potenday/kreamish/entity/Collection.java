package com.potenday.kreamish.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Collection extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long collectionId;

    @Length(min=1,max=50)
    @Column(name = "name", nullable = false, unique = true)
    @Setter
    private String name;
    public static Collection of(String name) {
        return new Collection(null, name);
    }
}