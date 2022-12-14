import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(1,"1984", 900, "Джодж Оруэлл");
    Product smartphone1 = new Smartphone(2, "iPhone 6s", 10_000, "Apple");
    Product book2 = new Book(3,"Убить пересмешника", 600, "Харпер Ли");

    @Test
    public void shouldSaveProduct() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.removeById(book1.getId());

        Product[] expected = {smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProducts() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
