package br.com.silvanopessoa.model.transformation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The Class ObjectToSerializableAssembler.
 */
public final class ObjectToSerializableAssembler {

	/**
	 * Instantiates a new object to serializable assembler.
	 */
	private ObjectToSerializableAssembler() {
	}
	
	/**
	 * Object to bytes.
	 *
	 * @param serializable the serializable
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static byte[] objectToBytes(Serializable serializable) throws IOException{
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream=  null;
		byte[] result = null;
		try{
			byteArrayOutputStream =  new ByteArrayOutputStream();
			objectOutputStream =  new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(serializable);
			result = byteArrayOutputStream.toByteArray();
		}finally{
			byteArrayOutputStream.close();
			objectOutputStream.close();
		}
		return result;
	}
}
