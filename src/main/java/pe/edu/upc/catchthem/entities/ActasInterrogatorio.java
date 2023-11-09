package pe.edu.upc.catchthem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name = "ActasInterrogatorio")
public class ActasInterrogatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_acta;
    @Column(name = "detalles",length = 50,nullable = false)
    private String detalles;
    @Column(name = "fecha",nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Users usuario;

    @ManyToOne
    @JoinColumn(name = "id_sospechoso")
    @JsonIgnore
    private Sospechoso sospechoso;

    public ActasInterrogatorio() {
    }

    public ActasInterrogatorio(int id_acta, String detalles, LocalDate fecha, Users usuario, Sospechoso sospechoso) {
        this.id_acta = id_acta;
        this.detalles = detalles;
        this.fecha = fecha;
        this.usuario = usuario;
        this.sospechoso = sospechoso;
    }

    public int getId_acta() {
        return id_acta;
    }
    public void setId_acta(int id_acta) {
        this.id_acta = id_acta;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }
}
