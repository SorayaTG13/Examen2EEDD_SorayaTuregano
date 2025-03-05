package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        // Inicializa la biblioteca y añade libros de ejemplo
        biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("El Quijote", "Cervantes", 1605));
        biblioteca.agregarLibro(new Libro("1984", "George Orwell", 1949));
    }

    // Test para agregar libros
    @Test
    public void testAgregarLibro() {
        // Asegurarse de que la biblioteca tiene 2 libros inicialmente
        assertEquals(2, biblioteca.getLibros().size(), "La biblioteca debe tener 2 libros");

        // Agregar un libro más
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));

        // Verificar que el libro fue agregado
        assertEquals(3, biblioteca.getLibros().size(), "La biblioteca debe tener ahora 3 libros");
    }

    // Test para eliminar libros
    @Test
    public void testEliminarLibro() {
        // Asegurarse de que la biblioteca tiene 2 libros
        assertEquals(2, biblioteca.getLibros().size(), "La biblioteca debe tener 2 libros");

        // Eliminar un libro
        Libro libroAEliminar = biblioteca.encuentraLibroPorTitulo("1984");
        boolean libroEliminado = biblioteca.eliminarLibro(libroAEliminar);

        // Verificar que el libro fue eliminado correctamente
        assertTrue(libroEliminado, "El libro debería haber sido eliminado correctamente");
        assertEquals(1, biblioteca.getLibros().size(), "La biblioteca debe tener 1 libro después de la eliminación");
    }

    // Test para buscar un libro por su título (cuando existe)
    @Test
    public void testEncuentraLibroPorTituloExistente() {
        // Buscar por título de un libro que existe
        Libro libro = biblioteca.encuentraLibroPorTitulo("El Quijote");

        // Verificar que el libro encontrado no sea nulo y sea el correcto
        assertNotNull(libro, "El libro debería ser encontrado");
        assertEquals("El Quijote", libro.getTitulo(), "El libro encontrado debe ser 'El Quijote'");
    }

    // Test para buscar un libro por su título (cuando no existe)
    @Test
    public void testEncuentraLibroPorTituloNoExistente() {
        // Buscar por título de un libro que no existe
        Libro libro = biblioteca.encuentraLibroPorTitulo("La sombra del viento");

        // Verificar que no se encuentre el libro
        assertNull(libro, "El libro no debería ser encontrado");
    }

    // Test para buscar libros por autor (cuando existe al menos un libro)
    @Test
    public void testEncuentraLibrosPorAutorExistente() {
        // Buscar libros por autor "Cervantes"
        List<Libro> librosDeCervantes = biblioteca.encuentraLibrosPorAutor("Cervantes");

        // Verificar que se devuelvan los libros del autor y no sean nulos
        assertNotNull(librosDeCervantes, "La lista de libros no debería ser null");
        assertFalse(librosDeCervantes.isEmpty(), "La lista de libros no debería estar vacía");
        assertEquals(1, librosDeCervantes.size(), "Debe haber un libro de Cervantes");
        assertEquals("El Quijote", librosDeCervantes.get(0).getTitulo(), "El libro encontrado debe ser 'El Quijote'");
    }

    // Test para buscar libros por autor (cuando no existe libros del autor)
    @Test
    public void testEncuentraLibrosPorAutorNoExistente() {
        // Buscar libros por un autor inexistente
        List<Libro> librosDeAutorNoExistente = biblioteca.encuentraLibrosPorAutor("Autor Inexistente");

        // Verificar que la lista esté vacía
        assertNotNull(librosDeAutorNoExistente, "La lista de libros no debería ser null");
        assertTrue(librosDeAutorNoExistente.isEmpty(), "La lista de libros debería estar vacía");
    }

    // Test para el método obsoleto (encuentraLibroPorAutor) usando @Deprecated
    @Test
    public void testEncuentraLibroPorAutorObsoleto() {
        // Buscar un libro por autor utilizando el método obsoleto
        Libro libro = biblioteca.encuentaLibroPorAutor("Cervantes");

        // Verificar que se encuentra el libro
        assertNotNull(libro, "El libro debería ser encontrado");
        assertEquals("El Quijote", libro.getTitulo(), "El libro encontrado debe ser 'El Quijote'");
    }
}
