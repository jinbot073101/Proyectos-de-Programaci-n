package Control;

import Modelo.PerroVO;

public interface IControlPerro {

    public void ingresarPerro(PerroVO perro);

    public PerroVO consultarPerro(String id);

    public boolean modificarPerro(PerroVO perroModificado);

    public boolean eliminarPerro();
}
