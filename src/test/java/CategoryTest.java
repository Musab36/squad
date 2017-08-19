import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void category_instantiatesCorrectly_true() {
        Category testCategory = new Category("Fighting beasts");
        assertEquals(true, testCategory instanceof Category);
    }

    @Test
    public void getName_categoryInstantiatesWithName_FightingBeasts() {
        Category testCategory = new Category("Fighting beasts");
        assertEquals("Fighting beasts", testCategory.getName());
    }

    @Test
    public void all_returnsAllInstancesOfCategory_true() {
        Category firstCategory = new Category("Fighting beasts");
        Category secondCategory = new Category("Fighting criminals");
        assertEquals(true, Category.all().contains(firstCategory));
        assertEquals(true, Category.all().contains(secondCategory));
    }

    @Test
    public void clear_emptiesAllCategoriesFromList_0() {
        Category testCategory = new Category("Fighting beasts");
        Category.clear();
        assertEquals(Category.all().size(), 0);
    }

    @Test
    public void getId_categoriesInstantiateWithAnId_1() {
        Category testCategory = new Category("Fighting beasts");
        assertEquals(1, testCategory.getId());
    }

    @Test
    public void find_returnsCategoryWithSameId_secondCategory() {
        Category.clear();
        Category firstCategory = new Category("Fighting beasts");
        Category secondCategory = new Category("Fighting criminals");
        assertEquals(Category.find(secondCategory.getId()), secondCategory);
    }
    @Test
    public void getTasks_initiallyReturnsEmptyList_ArrayList() {
        Category.clear();
        Category testCategory = new Category("Fighting beasts");
        assertEquals(0, testCategory.getSquads().size());
    }

    @Test
    public void addTask_addsTasksToList_true() {
        Category testCategory = new Category("Fighting beasts");
        Squad testSquad = new Squad("Fighting aliens");
        testCategory.addSquad(testSquad);
        assertTrue(testCategory.getSquads().contains(testSquad));
    }
}
