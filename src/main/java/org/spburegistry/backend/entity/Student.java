package org.spburegistry.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.spburegistry.backend.enums.Degree;
import org.spburegistry.backend.enums.Sex;

import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
@Data
public class Student extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(nullable = false)
    private int grade;

    @ManyToOne
    @JoinColumn(name = "educational_program_id", nullable = false)
    private EducationalProgram educationalProgram;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToMany(mappedBy = "students")
    private Set<Project> projects;

    @OneToMany(mappedBy = "student")
    private Set<Commit> commits;

    @OneToMany(mappedBy = "student")
    private Set<ProjectRole> roles;
}
