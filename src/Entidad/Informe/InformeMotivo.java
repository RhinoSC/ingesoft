package Entidad.Informe;

import DAO.CitaDAO;
import DAO.ComplimentDAO;
import Entidad.Cita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InformeMotivo extends Informe {

    private final int filtro;

    public InformeMotivo(int filtroMotivo) {
        this.genFecha = LocalDate.now();
        this.filtro = filtroMotivo;
        this.citas = new ArrayList<>();
        this.setCitas();
    }

    @Override
    protected void setCitas() {
        List<Cita> citaList = new CitaDAO().obtener();
        citaList.addAll(new ComplimentDAO().obtener());

        for (Cita cita : citaList) {
            if (cita.getMotivo() == this.filtro) this.citas.add(cita);
        }
    }

    @Override
    public void setCitas(ArrayList<Cita> citaList) {
        for (Cita cita : citaList) {
            if (cita.getMotivo() == this.filtro) this.citas.add(cita);
        }
    }

    public int getFiltro() { return filtro; }
}
