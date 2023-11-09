package pe.edu.upc.catchthem.entities;

import javax.persistence.*;

@Entity
@Table(name = "TipoEntidad")
public class TipoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;
    @Column(name = "sector",length = 15,nullable = false)
    private String sector;

    public TipoEntidad(int idTipo, String sector) {
        this.idTipo = idTipo;
        this.sector = sector;
    }

    public TipoEntidad() {
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
