package modelo;

import java.util.ArrayList;

public interface IPerroDao {

    public void registrar(PerroVO perro);

    public void modificar(PerroVO perro);

    public void consultar(String parametro, String valor);

    public void eliminar();

    public ArrayList<PerroVO> listaDeRazas();
    
    public ArrayList<PerroVO> traerPerrosIncompletos();
    
    public PerroVO traerPerroActualizar(int id);

}
