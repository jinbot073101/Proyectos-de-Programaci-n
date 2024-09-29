package Modelo;

import java.util.ArrayList;

public interface IPerroDao {

    public void ingresarPerro(PerroVO perro);

    public boolean modificarPerro();

    public ArrayList<PerroVO> listaDePerros();

}
