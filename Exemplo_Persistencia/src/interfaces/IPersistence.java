package interfaces;

import java.util.ArrayList;

/**
 * @author barbarasperinas
 *
 */
public interface IPersistence<T> {

	public void cadastrar(T object);

	public ArrayList<T> listar();

}
