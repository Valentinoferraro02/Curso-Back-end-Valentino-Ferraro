/* 
// Categoria.java
@Entity
@Table(name = "categorias")
public class Categoria {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;

@OneToMany(mappedBy = "categoria")
private List<Articulo> articulos; // Relación OneToMany

// Getters y setters
}

// Proveedor.java
@Entity
@Table(name = "proveedores")
public class Proveedor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;

@ManyToMany
@JoinTable(
name = "articulos_proveedores",
joinColumns = @JoinColumn(name = "proveedor_id"),
inverseJoinColumns = @JoinColumn(name = "articulo_id")
)
private List<Articulo> articulos; // Relación ManyToMany

// Getters y setters
}

// Etiqueta.java
@Entity
@Table(name = "etiquetas")
public class Etiqueta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;

@ManyToMany
@JoinTable(
name = "articulos_etiquetas",
joinColumns = @JoinColumn(name = "etiqueta_id"),
inverseJoinColumns = @JoinColumn(name = "articulo_id")
)
private List<Articulo> articulos; // Relación ManyToMany

// Getters y setters
}

// Imagen.java
@Entity
@Table(name = "imagenes")
public class Imagen {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String url;

@OneToOne
@JoinColumn(name = "articulo_id")
private Articulo articulo; // Relación OneToOne

// Getters y setters
}

// Articulo.java
@Entity
@Table(name = "articulos")
public class Articulo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String titulo;
private String descripcion;

@ManyToOne
@JoinColumn(name = "categoria_id", nullable = false)
private Categoria categoria; // Relación ManyToOne

@OneToOne(mappedBy = "articulo")
private Imagen imagen; // Relación OneToOne

@ManyToMany
@JoinTable(
name = "articulos_proveedores",
joinColumns = @JoinColumn(name = "articulo_id"),
inverseJoinColumns = @JoinColumn(name = "proveedor_id")
)
private List<Proveedor> proveedores; // Relación ManyToMany

@ManyToMany
@JoinTable(
name = "articulos_etiquetas",
joinColumns = @JoinColumn(name = "articulo_id"),
inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
)
private List<Etiqueta> etiquetas; // Relación ManyToMany

// Getters y setters
}

*/
//ManyToOne: un articulo pertenece a una categoria
//OneToMany: una categoria tiene muchos articulos
//OneToOne: un articulo tiene una imagen
//ManyToMany: un articulo puede tener muchos proveedores y un proveedor puede tener muchos articulos