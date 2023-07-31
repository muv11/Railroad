package com.muv.railroadrepair.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "region", schema = "public", catalog = "railroad_transport")
public class Region {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    @NonNull private String name;

}
