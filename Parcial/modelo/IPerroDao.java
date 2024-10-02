package modelo;

import java.util.ArrayList;

public interface IPerroDao {

    public void registrar(PerroVO perro);

    public boolean modificar(int id);

    public void consultar(String parametro, String valor);

    public void eliminar();

    public ArrayList<PerroVO> listaDePerros();

}
