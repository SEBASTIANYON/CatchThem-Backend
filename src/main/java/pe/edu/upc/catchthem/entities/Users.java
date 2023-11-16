package pe.edu.upc.catchthem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30, unique = true)
	private String username;
	@Column(length = 200)
	private String password;
	private Boolean enabled;
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "correo", length = 60, nullable = false)
	private String correo;
	@Column(name = "telefono", length = 9, nullable = false)
	private String telefono;

	@Column(name = "imagen")
	private String imagen;
	@ManyToOne
	@JoinColumn(name = "id_entidad")
	private Entidad entidad;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;


	public Users() {
	}

	public Users(Long id, String username, String password, Boolean enabled, String nombre, String correo, String telefono, String imagen, Entidad entidad, List<Role> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.imagen = imagen;
		this.entidad = entidad;
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}