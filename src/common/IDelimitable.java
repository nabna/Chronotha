package common;


public interface IDelimitable<T> extends Cloneable {

	String serialize(String _DELIMITER);

	T parse(String tuple, String _DELIMITER);

	T clone();

}
