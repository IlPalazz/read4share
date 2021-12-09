package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "username_unique", columnNames = "username"),
        @UniqueConstraint(name = "email_unique", columnNames = "email_addr")
})
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username", nullable = false)
    @Size(min = 5, max = 64)
    @NotNull
    @NotBlank
    private String username;
    @Column(name = "passw", nullable = false)
    @Size(min = 8, max = 64)
    @NotNull
    @NotBlank
    private String password;
    @Column(name = "email_addr", nullable = false)
    @Size(min = 5, max = 255)
    @NotNull
    @NotBlank
    private String email;

    /**
     * Advertisements published by a user
     */
    @OneToMany(mappedBy = "seller",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Adv> adverts;

    /**
     * List of messages sent by a user
     */
    @OneToMany(mappedBy = "sender",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Message> messages;

    /**
     * User favourite categories
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_category",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id"))
    private Set<Category> categories;

    /**
     * User's roles
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    // Methods used to sync both sides of the bidirectional association
    public void addMessage(Message mess) {
        messages.add(mess);
        mess.setSender(this);
    }

    public void removeMessage(Message mess) {
        messages.remove(mess);
        mess.setSender(null);
    }

    public void addAdv(Adv adv) {
        adverts.add(adv);
        adv.setSeller(this);
    }

    public void removeAdv(Adv adv) {
        adverts.remove(adv);
        adv.setSeller(null);
    }

}

