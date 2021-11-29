package br.com.letscode.starwars.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Rebel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private Gender gender;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Locate locate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Inventory inventory;

    @Column
    private int reportTraitor;

    @Column
    private boolean traitor;

    public void setReportTraitor() {
        this.reportTraitor += 1;
        if (this.reportTraitor >= 3) {
            this.traitor = true;
        }
    }

}
