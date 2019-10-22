package cn.run.java.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 13:04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "bs_dept")
public class Dept extends AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false)
  private Boolean status = true;

  @NotNull
  @Column(nullable = false)
  private Long sort;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "bs_user_dept",
          joinColumns = {@JoinColumn(name = "dept_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
  @BatchSize(size = 20)
  private Set<User> users = new HashSet<>();
}
