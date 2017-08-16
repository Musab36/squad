import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Squad mySquad = new Squad("Hero squad");
    assertEquals(true, mySquad instanceof Squad);
  }

  @Test
  public void Squad_instantiatesWithName_String() {
  	Squad mySquad = new Squad("Hero squad");
  	assertEquals("Hero squad", mySquad.getName());
  }

}	