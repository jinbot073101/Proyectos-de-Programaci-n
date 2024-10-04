package Modelo;

import java.util.ArrayList;


public interface IPerroDAO {
    
    public void registrar(PerroVO perro);

    public void modificar(PerroVO perroModificado);

    public void consultar(String parametro, String valor);

    public void eliminar();

    public ArrayList<PerroVO> listaDeRazas();
    
    public ArrayList<PerroVO> traerPerrosIncompletos();
    
    public PerroVO traerPerroActualizar(int id);

    
}
