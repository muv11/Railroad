package com.muv.railroadrepair.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "city", schema = "public", catalog = "railroad_transport")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    @NonNull private String name;
    /*@Basic
    @Column(name = "region")
    private Integer region;*/
    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private Region regionById;

}
