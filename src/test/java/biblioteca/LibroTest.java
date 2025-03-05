package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    @Test
    public void testConstructorYGetters() {
        // Crear un libro usando el constructor
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 1605);

        // Comprobar que los valores del libro coinciden con los valores establecidos
        assertEquals("El Quijote", libro.getTitulo());
        assertEquals("Miguel de Cervantes", libro.getAutor());
        assertEquals(1605, libro.getAnioPublicacion());
    }

    @Test
    public void testSetters() {
        // Crear un libro y luego modificar sus valores
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        libro.setTitulo("Don Quijote de la Mancha");
        libro.setAutor("Cervantes");
        libro.setAnioPublicacion(1615);

        // Comprobar que los setters funcionan correctamente
        assertEquals("Don Quijote de la Mancha", libro.getTitulo());
        assertEquals("Cervantes", libro.getAutor());
        assertEquals(1615, libro.getAnioPublicacion());
    }
}
