import com.example.comp1008assignment02200368110.Product;
import com.example.comp1008assignment02200368110.Store;
import static org.junit.Assert.*;
import java.util.Arrays;

public class Tests {
    private Store store;
    private Product product;

    @org.junit.Before
    public void setUp()
    {
        store = new Store("Zehrs", Arrays.asList("Natural Foods", "Health", "Beauty", "Grocery", "Dairy", "Frozen"), 6, 10, 8);
        product = new Product("Test Product", "123456789012", "123456789", "Grocery", 1, 1, 1, store);
    }

    @org.junit.Test
    public void testValidName()
    {
        assertTrue(product.isValidName("Test Product")); // Valid Name between 2-50 characters
        assertFalse(product.isValidName("")); // Name cannot be empty
        assertFalse(product.isValidName("T")); // Name cannot be less than 2 characters
        assertFalse(product.isValidName("This Product Name Should Be Too Long For This Method")); // Name cannot be greater than 50 characters
    }

    @org.junit.Test
    public void testValidUpc()
    {
        assertTrue(product.isValidUpc("123456789012")); // New UPC + 12 Characters
        assertTrue(product.isValidUpc("")); // Empty UPC is fine
        assertFalse(product.isValidUpc("1234567890123")); // Too Long
        assertFalse(product.isValidUpc("123")); // Too Short
        assertFalse(product.isValidUpc("1234abc89012")); // Has letters
        assertFalse(product.isValidUpc("!@#$%^&*()!@")); // Has Special Characters

        store.addItem(product);
        assertTrue(product.isValidUpc("123456789012")); // UPC Already Exists, but is true because the product is the same product as the one with this UPC

        Product product2 = new Product("Test Product 2", "999999999999", "999999999", "Grocery", 1, 2, 3, store);
        store.addItem(product2);

        assertFalse(product2.isValidUpc("123456789012")); // UPC Already Exists

        store.getProducts().clear(); // Reset Store
    }

    @org.junit.Test
    public void testValidId()
    {
        assertTrue(product.isValidId("123456789")); // Valid Id
        assertTrue(product.isValidId("")); // Empty Id is fine
        assertFalse(product.isValidId("1234567890")); // Too Long
        assertFalse(product.isValidId("123")); // Too Short
        assertFalse(product.isValidId("1234abc89")); // Has letters
        assertFalse(product.isValidId("!@#$%^&*(")); // Has Special Characters

        store.addItem(product);
        assertTrue(product.isValidId("123456789")); // Id Already Exists, but is true because the product is the same product as the one with this Id

        Product product2 = new Product("Test Product 2", "999999999999", "999999999", "Grocery", 1, 2, 3, store);
        store.addItem(product2);

        assertFalse(product2.isValidId("123456789")); // Id Already Exists

        store.getProducts().clear(); // Reset Store
    }

    @org.junit.Test
    public void testGetName()
    {
        assertEquals(product.getName(), "Test Product");
    }

    @org.junit.Test
    public void testGetUpc()
    {
        assertEquals(product.getUpc(), "123456789012");
    }

    @org.junit.Test
    public void testGetItemId()
    {
        assertEquals(product.getItemId(), "123456789");
    }

    @org.junit.Test
    public void testGetDepartment()
    {
        assertEquals(product.getDepartment(), "Grocery");
    }

    @org.junit.Test
    public void testGetAisle()
    {
        assertEquals(product.getAisle(), 1);
    }

    @org.junit.Test
    public void testGetShelf()
    {
        assertEquals(product.getShelf(), 1);
    }

    @org.junit.Test
    public void testGetRow()
    {
        assertEquals(product.getRow(), 1);
    }

    @org.junit.Test
    public void testToString()
    {
        assertEquals(product.toString(), "Test Product");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidName()
    {
        product.setName("");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidUpc()
    {
        product.setUpc("123");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidId()
    {
        product.setItemId("123");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidDepartment()
    {
        product.setDepartment("Invalid Department");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidAisle()
    {
        product.setAisle(123);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidShelf()
    {
        product.setShelf(123);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testInvalidRow()
    {
        product.setRow(123);
    }

    @org.junit.Test
    public void testGetStoreName()
    {
        assertEquals(store.getName(), "Zehrs");
    }

    @org.junit.Test
    public void testGetItemByUpc()
    {
        assertFalse(store.hasProductByUpc(""));
    }

    @org.junit.Test
    public void testGetItemById()
    {
        assertFalse(store.hasProductById(""));
    }

    @org.junit.Test
    public void testGetProductsFromDepartment()
    {
        assertEquals(store.getProductsFromDepartment("Natural Foods").size(), 0);
    }

    @org.junit.Test
    public void testGetProductsFromAisle()
    {
        assertEquals(store.getProductsFromAisle(0).size(), 0);
    }
}
