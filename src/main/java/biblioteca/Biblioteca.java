package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // TODO: Documentar estos atributos
    /** Lista que almacena los libros de la biblioteca. */
    private final List<Libro> libros;

    // TODO: Documentar este método
    /**
     * Constructor que inicializa la biblioteca con una lista vacía de libros.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    // TODO: Documentar este método.
    //  Test: NO HAY QUE TESTEAR ESTE METODO
    /**
     * Constructor que inicializa la biblioteca con una lista preexistente de libros.
     *
     * @param libros Lista de libros que se agregará a la biblioteca.
     */
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    // TODO: Testear este metodo.
    //  Test: Comprobar si se ha agregado
    /**
     * Agrega un libro a la biblioteca.
     *
     * @param libro El libro que se agregará a la biblioteca.
     * @return {@code true} si el libro se agregó correctamente, {@code false} si no.
     */
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    // TODO: Testear este metodo.
    //  Test: comprobar si se ha eliminado
    /**
     * Elimina un libro de la biblioteca.
     *
     * @param libro El libro que se eliminará de la biblioteca.
     * @return {@code true} si el libro se eliminó correctamente, {@code false} si no.
     */
    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    // TODO: Documentar este método
    /**
     * Obtiene la lista completa de libros en la biblioteca.
     *
     * @return Una lista de todos los libros en la biblioteca.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    // TODO: Documentar este método.
    //  Test 01: buscar libro existente y comprobar que lo localiza.
    //  Test 02: buscar libro NO existente y comprobar que no lo localiza.
    /**
     * Busca un libro en la biblioteca por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return El libro encontrado con el título dado, o {@code null} si no se encuentra.
     */
    public Libro encuentraLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    // TODO: Documentar este metodo.
    //  No testearlo
    /**
     * Método obsoleto que busca un libro por su autor.
     *
     * @deprecated Este método está obsoleto. Usa {@link #encuentraLibrosPorAutor(String)} en su lugar.
     * @param autor El autor del libro a buscar.
     * @return El primer libro encontrado con el autor dado, o {@code null} si no se encuentra.
     */
    // Este metodo está obsoleto. Hay que documentarlo como tal.
    //  Recuerda: las anotaciones @deprecated y @link a la nueva
    //  versión mejorada encuentraLibrosPorAutor(...)
    //  En esta ocasión, NO TESTEAREMOS este metodo
    @Deprecated
    public Libro encuentaLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    // TODO: Documentar este metodo
    // Este metodo sustituye al metodo anterior. Está disponible desde la
    //  versión 2.0. Hay que documentarlo teniéndolo en cuenta.
    // TODO: Testear este metodo.
    //  Test: Comprobar la lista de libros que devuelve para un autor existentes.
    //  Test: Comprobar la lista de libros que devuelve para un autor No existente
    /**
     * Busca todos los libros de un autor específico.
     *
     * @param autor El autor de los libros a buscar.
     * @return Una lista de libros escritos por el autor dado. Si no se encuentran, se retorna una lista vacía.
     */
    public List<Libro> encuentraLibrosPorAutor(String autor) {
        List<Libro> listaLibros = null;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                if (listaLibros == null) {
                    listaLibros = new ArrayList<>();
                }
                listaLibros.add(libro);
            }
        }
        return listaLibros;
    }
}
