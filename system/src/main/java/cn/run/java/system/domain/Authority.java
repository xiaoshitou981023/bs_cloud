package cn.run.java.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 10:39
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "bs_authority")
public class Authority extends AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Pattern(regexp = "^[_.@A-Za-z0-9-]*$")
  @Size(min = 1, max = 50)
  @Column(length = 50, unique = true, nullable = false)
  private String name;

  @NotNull
  @Size(min = 1)
  @Column(unique = true, nullable = false)
  private String code;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "bs_role_authority",
          joinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  @BatchSize(size = 20)
  private Set<Authority> authorities = new HashSet<>();
}
