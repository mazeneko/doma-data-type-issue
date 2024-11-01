package boilerplate.java17.entity;

import org.seasar.doma.Domain;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Version;

@Entity(metamodel = @Metamodel)
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "EMPLOYEE_SEQ")
  public Integer id;

  public Name name;

  public Integer age;

  @Version public Integer version;

  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", version=" + version + "]";
  }

  @Domain(valueType = String.class, accessorMethod = "value")
  public record Name(String value) {
    public Name {
      if(value.isEmpty()){
        throw new IllegalArgumentException();
      }
    }
  }
}
