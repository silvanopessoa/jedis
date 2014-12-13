package br.com.silvanopessoa.model.transformation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * The Class ObjectToSerializableAssembler.
 */
public final class SerializableToObjectAssembler {

	/**
	 * Instantiates a new serializable to object assembler.
	 */
	private SerializableToObjectAssembler() {
	}
	
	/**
	 * Bytes to object.
	 *
	 * @param bytes the bytes
	 * @return the serializable
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static Serializable bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException{
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		try{
			byteArrayInputStream = new ByteArrayInputStream(bytes);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			return (Serializable) objectInputStream.readObject();
		}finally{
			byteArrayInputStream.close();
			objectInputStream.close();
		}
	}
	
}
