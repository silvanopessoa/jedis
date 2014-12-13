package br.com.silvanopessoa.model.transformation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The Class ObjectToSerializableAssembler.
 */
public class ObjectToSerializableAssembler {

	/**
	 * Object to bytes.
	 *
	 * @param serializable the serializable
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public byte[] objectToBytes(Serializable serializable) throws IOException{
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
	
	/**
	 * Bytes to object.
	 *
	 * @param bytes the bytes
	 * @return the serializable
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Serializable bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException{
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
